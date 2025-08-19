package com.example.chukaokoyecsandroidtechtest2025.ui.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chukaokoyecsandroidtechtest2025.ui.model.CreditInfoUIModel

@Composable
fun MainScreen(creditInfo: CreditInfoUIModel) {

    val targetProgress = if (creditInfo.maxScoreValue != 0)
        creditInfo.score.toFloat() / creditInfo.maxScoreValue.toFloat()
    else 0f

    val progressAnim = remember { Animatable(0f) }

    LaunchedEffect(targetProgress) {
        progressAnim.snapTo(0f)
        progressAnim.animateTo(
            targetValue = targetProgress,
            animationSpec = tween(
                durationMillis = 1200,
                easing = FastOutSlowInEasing
            )
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(250.dp)
                .border(2.dp, Color.Black, CircleShape)
                .padding(8.dp)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val strokeWidth = 5.dp.toPx()

                val inset = strokeWidth / 2f
                val topLeft = Offset(inset, inset)
                val arcSize = Size(
                    size.width - inset * 2f,
                    size.height - inset * 2f
                )

                drawArc(
                    color = creditInfo.ringColor,
                    startAngle = -90f,
                    sweepAngle = 360f * progressAnim.value,
                    useCenter = false,
                    style = Stroke(
                        width = strokeWidth,
                        cap = StrokeCap.Round
                    ),
                    topLeft = topLeft,
                    size = arcSize
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Your credit score is",
                    style = TextStyle(fontSize = 18.sp),
                    textAlign = TextAlign.Center
                )
                Text(
                    creditInfo.score.toString(),
                    style = TextStyle(
                        fontSize = 70.sp,
                        fontWeight = FontWeight.Light,
                        color = creditInfo.scoreColor
                    ),
                    textAlign = TextAlign.Center
                )
                Text(
                    "out of ${creditInfo.maxScoreValue}",
                    style = TextStyle(fontSize = 18.sp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}




