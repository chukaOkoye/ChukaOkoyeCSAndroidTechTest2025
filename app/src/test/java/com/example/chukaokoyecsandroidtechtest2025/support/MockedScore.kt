package com.example.chukaokoyecsandroidtechtest2025.support

import androidx.compose.ui.graphics.Color
import com.example.chukaokoyecsandroidtechtest2025.data.model.CoachingSummary
import com.example.chukaokoyecsandroidtechtest2025.data.model.CreditReportInfo
import com.example.chukaokoyecsandroidtechtest2025.data.model.CreditScore
import com.example.chukaokoyecsandroidtechtest2025.ui.model.CreditInfoUIModel

object MockedScores {

    val mockCreditScore = CreditScore(
        accountIDVStatus = "PASS",
        augmentedCreditScore = null,
        coachingSummary = CoachingSummary(
            activeTodo = true,
            activeChat =true,
            numberOfTodoItems = 0,
            numberOfCompletedTodoItems = 0,
            selected = true
        ),
        creditReportInfo = CreditReportInfo(
            score = 650,
            maxScoreValue = 700,
            minScoreValue = 0,
            changeInLongTermDebt = 0,
            changeInShortTermDebt = 0,
            changedScore = 0,
            clientRef = "",
            currentLongTermCreditLimit = 0,
            currentLongTermCreditUtilisation = 0,
            currentLongTermDebt = 2,
            currentLongTermNonPromotionalDebt = 0,
            currentShortTermCreditLimit = 0,
            currentShortTermCreditUtilisation = 0,
            currentShortTermDebt = 0,
            currentShortTermNonPromotionalDebt = 0,
            daysUntilNextReport = 0,
            equifaxScoreBand = 0,
            equifaxScoreBandDescription = "",
            hasEverBeenDelinquent = true,
            hasEverDefaulted = true,
            monthsSinceLastDefaulted = 0,
            monthsSinceLastDelinquent = 0,
            numNegativeScoreFactors = 0,
            numPositiveScoreFactors = 0,
            percentageCreditUsed = 0,
            percentageCreditUsedDirectionFlag = 0,
            scoreBand = 0,
            status = "0",
        ),
        dashboardStatus = "PASS",
        personaType = "INEXPERIENCED"
    )

    val mockedCreditUIState = CreditInfoUIModel(
        score = 650,
        maxScoreValue = 700,
        ringColor = Color(0xFF4CAF50),
        scoreColor = Color(0xFF4CAF50)
    )

}