package com.example.berlin_bucket_list.model

import com.example.berlin_bucket_list.model.BerlinBucketListItem
import com.example.berlin_bucket_list.model.CategoryType

data class BerlinBucketListUiState(
    val currentCategory: CategoryType? = null,
    val placesToShow: List<BerlinBucketListItem> = emptyList(),
)