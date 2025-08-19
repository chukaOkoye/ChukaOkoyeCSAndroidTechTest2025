package com.example.chukaokoyecsandroidtechtest2025.data.model


import com.google.gson.annotations.SerializedName

data class CreditReportInfo(
    @SerializedName("changeInLongTermDebt")
    val changeInLongTermDebt: Int,
    @SerializedName("changeInShortTermDebt")
    val changeInShortTermDebt: Int,
    @SerializedName("changedScore")
    val changedScore: Int,
    @SerializedName("clientRef")
    val clientRef: String,
    @SerializedName("currentLongTermCreditLimit")
    val currentLongTermCreditLimit: Any?,
    @SerializedName("currentLongTermCreditUtilisation")
    val currentLongTermCreditUtilisation: Any?,
    @SerializedName("currentLongTermDebt")
    val currentLongTermDebt: Int,
    @SerializedName("currentLongTermNonPromotionalDebt")
    val currentLongTermNonPromotionalDebt: Int,
    @SerializedName("currentShortTermCreditLimit")
    val currentShortTermCreditLimit: Int,
    @SerializedName("currentShortTermCreditUtilisation")
    val currentShortTermCreditUtilisation: Int,
    @SerializedName("currentShortTermDebt")
    val currentShortTermDebt: Int,
    @SerializedName("currentShortTermNonPromotionalDebt")
    val currentShortTermNonPromotionalDebt: Int,
    @SerializedName("daysUntilNextReport")
    val daysUntilNextReport: Int,
    @SerializedName("equifaxScoreBand")
    val equifaxScoreBand: Int,
    @SerializedName("equifaxScoreBandDescription")
    val equifaxScoreBandDescription: String,
    @SerializedName("hasEverBeenDelinquent")
    val hasEverBeenDelinquent: Boolean,
    @SerializedName("hasEverDefaulted")
    val hasEverDefaulted: Boolean,
    @SerializedName("maxScoreValue")
    val maxScoreValue: Int,
    @SerializedName("minScoreValue")
    val minScoreValue: Int,
    @SerializedName("monthsSinceLastDefaulted")
    val monthsSinceLastDefaulted: Int,
    @SerializedName("monthsSinceLastDelinquent")
    val monthsSinceLastDelinquent: Int,
    @SerializedName("numNegativeScoreFactors")
    val numNegativeScoreFactors: Int,
    @SerializedName("numPositiveScoreFactors")
    val numPositiveScoreFactors: Int,
    @SerializedName("percentageCreditUsed")
    val percentageCreditUsed: Int,
    @SerializedName("percentageCreditUsedDirectionFlag")
    val percentageCreditUsedDirectionFlag: Int,
    @SerializedName("score")
    val score: Int,
    @SerializedName("scoreBand")
    val scoreBand: Int,
    @SerializedName("status")
    val status: String
)