/*
 * SPDX-FileCopyrightText: 2023 IacobIacob01
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wint.wintwealthgallery.feature_node.data.data_types

import android.content.ContentResolver
import android.os.Bundle
import android.provider.MediaStore
import com.wint.wintwealthgallery.feature_node.data.data_source.Query.MediaQuery
import com.wint.wintwealthgallery.feature_node.domain.model.Media
import com.wint.wintwealthgallery.feature_node.domain.util.MediaOrder
import com.wint.wintwealthgallery.feature_node.domain.util.OrderType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun ContentResolver.getMediaFavorite(
    mediaOrder: MediaOrder = MediaOrder.Date(OrderType.Descending)
): List<Media> {
    return withContext(Dispatchers.Default) {
        val mediaQuery = MediaQuery().copy(
            bundle = Bundle().apply {
                putInt(MediaStore.QUERY_ARG_MATCH_FAVORITE, MediaStore.MATCH_ONLY)
            }
        )
        return@withContext mediaOrder.sortMedia(getMedia(mediaQuery))
    }
}
