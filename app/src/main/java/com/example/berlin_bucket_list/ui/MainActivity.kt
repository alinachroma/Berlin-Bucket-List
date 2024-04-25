package com.example.berlin_bucket_list.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.example.berlin_bucket_list.ui.screens.BerlinBucketListApp
import com.example.berlin_bucket_list.ui.theme.BerlinBucketListTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BerlinBucketListTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val windowSize = calculateWindowSizeClass(activity = this)
                    WindowCompat.getInsetsController(window, window.decorView)
                        .hide(WindowInsetsCompat.Type.systemBars())
                    BerlinBucketListApp(windowSize = windowSize.widthSizeClass)
                }
            }
        }
    }
}

@Preview
@Composable
fun BerlinBucketListAppPreview() {
    BerlinBucketListTheme {
        Surface {
            BerlinBucketListApp(windowSize = WindowWidthSizeClass.Compact)
        }
    }
}
