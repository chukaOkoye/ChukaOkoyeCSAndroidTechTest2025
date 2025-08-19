package com.example.chukaokoyecsandroidtechtest2025.ui.mapper

import androidx.compose.ui.graphics.Color
import com.example.chukaokoyecsandroidtechtest2025.data.model.CreditScore
import com.example.chukaokoyecsandroidtechtest2025.ui.model.CreditInfoUIModel

fun CreditScore.toCreditInfoUIModel(): CreditInfoUIModel {
    val info = this.creditReportInfo

    val ringColor = when {
        info.score < info.maxScoreValue * 0.4 -> Color(0xFFF44336) // red
        info.score < info.maxScoreValue * 0.7 -> Color(0xFFFFC107) // yellow
        else -> Color(0xFF4CAF50) // green
    }

    return CreditInfoUIModel(
        score = info.score,
        maxScoreValue = info.maxScoreValue,
        ringColor = ringColor,
        scoreColor = ringColor
    )
}