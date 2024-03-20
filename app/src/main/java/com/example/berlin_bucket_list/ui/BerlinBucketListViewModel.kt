package com.example.berlin_bucket_list.ui

import androidx.lifecycle.ViewModel
import com.example.berlin_bucket_list.R
import com.example.berlin_bucket_list.data.DataSource
import com.example.berlin_bucket_list.model.BerlinBucketListItem
import com.example.berlin_bucket_list.model.BerlinBucketListUiState
import com.example.berlin_bucket_list.model.CategoryType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BerlinBucketListViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(BerlinBucketListUiState())
    val uiState: StateFlow<BerlinBucketListUiState> = _uiState.asStateFlow()

    fun updateCurrentCategory(clickedCategory: CategoryType) {
        _uiState.update {
            it.copy(
                currentCategory = clickedCategory,
                placesToShow = when (clickedCategory.title) {
                    R.string.category_1 -> DataSource.cafes
                    R.string.category_2 -> DataSource.parks
                    R.string.category_3 -> DataSource.shoppingCenters
                    R.string.category_4 -> DataSource.kidsFriendly
                    else -> emptyList()
                }
            )
        }
    }

    fun updateRecommendedPlace(recommendedPlace: BerlinBucketListItem) {
        _uiState.update {
            it.copy(
                recommendedPlace = recommendedPlace
            )
        }
    }
}