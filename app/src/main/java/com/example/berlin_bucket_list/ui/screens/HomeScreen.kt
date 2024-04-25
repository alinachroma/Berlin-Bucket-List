    windowSize: WindowWidthSizeClass,
    val contentType = when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            BerlinBucketListContentType.LIST_ONLY
        }

        WindowWidthSizeClass.Medium,
        WindowWidthSizeClass.Expanded -> {
            BerlinBucketListContentType.LIST_AND_DETAIL
        }

        else -> BerlinBucketListContentType.LIST_ONLY
    }
