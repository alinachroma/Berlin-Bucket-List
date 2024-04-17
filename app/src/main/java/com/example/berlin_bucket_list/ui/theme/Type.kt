package com.example.berlin_bucket_list.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.berlin_bucket_list.R

val AllertaStencilFamily = FontFamily(
    Font(R.font.allerta_stencil_regular, FontWeight.Normal)
)
val BubbleOne = FontFamily(
    Font(R.font.bubbler_one_regular, FontWeight.Normal)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displayMedium = TextStyle(
        fontFamily = AllertaStencilFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp
    ),
    displaySmall = TextStyle(
        fontFamily = AllertaStencilFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    labelMedium = TextStyle(
        fontFamily = AllertaStencilFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    bodySmall = TextStyle(
        fontFamily = BubbleOne,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
       titleLarge = TextStyle(
           fontFamily = FontFamily.Default,
           fontWeight = FontWeight.Normal,
           fontSize = 22.sp,
           lineHeight = 28.sp,
           letterSpacing = 0.sp
       ),
       labelSmall = TextStyle(
           fontFamily = FontFamily.Default,
           fontWeight = FontWeight.Medium,
           fontSize = 11.sp,
           lineHeight = 16.sp,
           letterSpacing = 0.5.sp
       )
       */
)