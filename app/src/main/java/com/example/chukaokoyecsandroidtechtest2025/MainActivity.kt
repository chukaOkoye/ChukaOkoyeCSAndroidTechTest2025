package com.example.chukaokoyecsandroidtechtest2025

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.chukaokoyecsandroidtechtest2025.ui.navigation.MainNavHost
import com.example.chukaokoyecsandroidtechtest2025.ui.viewmodel.CreditScoreViewModel
import com.example.chukaokoyecsandroidtechtest2025.ui.theme.ChukaOkoyeCSAndroidTechTest2025Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: CreditScoreViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChukaOkoyeCSAndroidTechTest2025Theme {
                MainNavHost(viewModel)
            }
        }
    }
}
