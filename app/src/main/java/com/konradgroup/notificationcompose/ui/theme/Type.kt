package com.konradgroup.notificationcompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.konradgroup.notificationcompose.R

private val podkovaBold = Font(R.font.podkova_bold, weight = FontWeight.Bold)
private val podkovaExtraBold = Font(R.font.podkova_extra_bold, weight = FontWeight.ExtraBold)
private val podkovaMedium = Font(R.font.podkova_medium, weight = FontWeight.Medium)
private val podkovaRegular = Font(R.font.podkova_regular, weight = FontWeight.Normal)
private val podkovaSemiBold = Font(R.font.podkova_semi_bold, weight = FontWeight.SemiBold)

private val podkova = FontFamily(
    listOf(
        podkovaBold,
        podkovaExtraBold,
        podkovaMedium,
        podkovaRegular,
        podkovaSemiBold
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = podkova,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    ),
    h2 = TextStyle(
        fontFamily = podkova,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        fontFamily = podkova,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    ),
    h4 = TextStyle(
        fontFamily = podkova,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body1 = TextStyle(
        fontFamily = podkova,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = podkova,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = podkova,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    caption = TextStyle(
        fontFamily = podkova,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = podkova,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)
