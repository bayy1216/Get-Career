package com.reditus.getcareer.data.dto

data class CareerModel(
    val id: String,
    val company: Company,
    val url: String,
    val title: String,
    val date: String,
)

enum class Company {
    NAVER,
    KAKAO,
    LINE,
    COUPANG,
    BAEMIN,
    OTHER
}