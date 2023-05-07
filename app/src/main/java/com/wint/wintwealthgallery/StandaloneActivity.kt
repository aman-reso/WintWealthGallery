/*
 * SPDX-FileCopyrightText: 2023 IacobIacob01
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wint.wintwealthgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.wint.wintwealthgallery.feature_node.presentation.standalone.StandaloneMediaViewScreen
import com.wint.wintwealthgallery.feature_node.presentation.standalone.StandaloneViewModel
import com.wint.wintwealthgallery.feature_node.presentation.util.uriToPath
import com.wint.wintwealthgallery.ui.theme.GalleryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StandaloneActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            GalleryTheme(darkTheme = true) {
                Scaffold { paddingValues ->
                    val viewModel = hiltViewModel<StandaloneViewModel>()
                    StandaloneMediaViewScreen(paddingValues, uriToPath(intent.data), viewModel)
                }
                BackHandler {
                    finish()
                }
            }
        }
    }
}