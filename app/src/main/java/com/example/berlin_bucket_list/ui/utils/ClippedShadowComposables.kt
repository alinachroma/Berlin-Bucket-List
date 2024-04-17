package com.example.berlin_bucket_list.ui.utils

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.addOutline
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp


/** These Composables fix the material shadow glitch
* on transparent/translucent Composables.
* Author: zed-alpha.
* Repo: https://gist.github.com/zed-alpha/3dc931720292c1f3ff31fa6a130f52cd
* */

@Composable
fun ClippedShadow(elevation: Dp, shape: Shape, modifier: Modifier = Modifier) {
    Layout(
        modifier
            .drawWithCache {
                val path = Path()
                var lastSize: Size? = null

                fun updatePathIfNeeded() {
                    if (size != lastSize) {
                        path.reset()
                        path.addOutline(
                            shape.createOutline(size, layoutDirection, this)
                        )
                        lastSize = size
                    }
                }

                onDrawWithContent {
                    updatePathIfNeeded()
                    clipPath(path, ClipOp.Difference) {
                        this@onDrawWithContent.drawContent()
                    }
                }
            }
            .shadow(elevation, shape)
    ) { _, constraints ->
        layout(constraints.minWidth, constraints.minHeight) {}
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun ShadowBox(
    elevation: Dp,
    shape: Shape,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        {
            ClippedShadow(elevation, shape, modifier)
            CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
                content()
            }
        },
        modifier
    ) { measurable, constraints ->
        require(measurable.size == 2)

        val shadow = measurable[0]
        val target = measurable[1]

        val targetPlaceable = target.measure(constraints)
        val width = targetPlaceable.width
        val height = targetPlaceable.height

        val shadowPlaceable = shadow.measure(Constraints.fixed(width, height))

        layout(width, height) {
            shadowPlaceable.place(0, 0)
            targetPlaceable.place(0, 0)
        }
    }
}