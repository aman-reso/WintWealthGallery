/*
 * SPDX-FileCopyrightText: 2023 IacobIacob01
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wint.wintwealthgallery.feature_node.data.data_types

import android.content.ContentResolver
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import com.wint.wintwealthgallery.feature_node.data.data_source.Query.MediaQuery
import com.wint.wintwealthgallery.feature_node.domain.model.Media
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun ContentResolver.getMediaByUri(uri: Uri): Media? {
    return withContext(Dispatchers.Default) {
        var media: Media? = null
        val mediaQuery = MediaQuery().copy(
            bundle = Bundle().apply {
                putString(
                    ContentResolver.QUERY_ARG_SQL_SELECTION,
                    MediaStore.MediaColumns.DATA + "=?"
                )
                putStringArray(
                    ContentResolver.QUERY_ARG_SQL_SELECTION_ARGS,
                    arrayOf(uri.toString())
                )
            }
        )
        with(query(mediaQuery)) {
            moveToFirst()
            while (!isAfterLast) {
                try {
                    media = getMediaFromCursor()
                    break
                } catch (e: Exception) {
                    close()
                    e.printStackTrace()
                }
            }
            moveToNext()
            close()
        }

        return@withContext media
    }
}