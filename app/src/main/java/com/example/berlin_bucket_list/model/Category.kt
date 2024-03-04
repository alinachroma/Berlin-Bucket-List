package com.example.berlin_bucket_list.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    @StringRes val categoryName: Int,
    @DrawableRes val categoryImage: Int
)