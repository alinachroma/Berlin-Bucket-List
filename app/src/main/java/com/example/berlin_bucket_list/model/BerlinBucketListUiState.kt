package com.example.berlin_bucket_list.model

data class BerlinBucketListUiState(
    val currentCategory: CategoryType? = null,
    val placesToShow: List<BerlinBucketListItem> = emptyList(),
    val recommendedPlace: BerlinBucketListItem? = null
)