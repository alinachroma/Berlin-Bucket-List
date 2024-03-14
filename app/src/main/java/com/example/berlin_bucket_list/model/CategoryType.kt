package com.example.berlin_bucket_list.model

import com.example.berlin_bucket_list.R

sealed class CategoryType(open val title: Int) {
    data object Cafes : CategoryType(title = R.string.category_1)
    data object Parks : CategoryType(title = R.string.category_2)
    data object Shopping : CategoryType(title = R.string.category_3)
    data object KidsFriendly : CategoryType(title = R.string.category_4)
}
