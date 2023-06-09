/*
 * SPDX-FileCopyrightText: 2023 IacobIacob01
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wint.wintwealthgallery.feature_node.data.data_types

import android.content.ContentResolver
import com.wint.wintwealthgallery.feature_node.data.data_source.Query
import com.wint.wintwealthgallery.feature_node.domain.model.Media
import com.wint.wintwealthgallery.feature_node.domain.util.MediaOrder
import com.wint.wintwealthgallery.feature_node.domain.util.OrderType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun ContentResolver.getMedia(
    mediaQuery: Query = Query.MediaQuery(),
    mediaOrder: MediaOrder = MediaOrder.Date(OrderType.Descending)
): List<Media> {
    return withContext(Dispatchers.Default) {
        val media = ArrayList<Media>()
        with(query(mediaQuery)) {
            moveToFirst()
            while (!isAfterLast) {
                try {
                    media.add(getMediaFromCursor())
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                moveToNext()
            }
            close()
        }
        return@withContext mediaOrder.sortMedia(media)
    }
}

suspend fun ContentResolver.findMedia(mediaQuery: Query): Media? {
    return withContext(Dispatchers.Default) {
        val mediaList = getMedia(mediaQuery)
        return@withContext if (mediaList.isEmpty()) null else mediaList.first()
    }
}