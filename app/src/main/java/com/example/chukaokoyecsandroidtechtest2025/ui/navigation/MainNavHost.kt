package com.example.chukaokoyecsandroidtechtest2025.ui.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chukaokoyecsandroidtechtest2025.ui.model.CreditScoreUIState
import com.example.chukaokoyecsandroidtechtest2025.ui.screens.ErrorScreen
import com.example.chukaokoyecsandroidtechtest2025.ui.screens.LoadingScreen
import com.example.chukaokoyecsandroidtechtest2025.ui.screens.MainScreen
import com.example.chukaokoyecsandroidtechtest2025.ui.viewmodel.CreditScoreViewModel

@Composable
fun MainNavHost(viewModel: CreditScoreViewModel) {
    val navController = rememberNavController()
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.fetchCreditScore()
    }

    LaunchedEffect(uiState) {
        val route = when (uiState) {
            is CreditScoreUIState.Loading -> "loading"
            is CreditScoreUIState.Error   -> "error"
            is CreditScoreUIState.Success -> "score"
        }
        if (navController.currentDestination?.route != route) {
            navController.navigate(route) {
                popUpTo(navController.graph.startDestinationId) { inclusive = true }
                launchSingleTop = true
            }
        }
    }

    NavHost(navController = navController, startDestination = "loading") {
        composable("loading") { LoadingScreen() }
        composable("error") {
            val state = uiState as? CreditScoreUIState.Error
            ErrorScreen(
                message = state?.message ?: "Unknown error",
                onRetry = { viewModel.fetchCreditScore() }
            )
        }
        composable("score") {
            val state = uiState as? CreditScoreUIState.Success
            state?.let { MainScreen(creditInfo = it.userScore) }
        }
    }
}




