/*
 * SPDX-FileCopyrightText: 2023 IacobIacob01
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wint.wintwealthgallery.feature_node.domain.repository

import android.media.MediaScannerConnection
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import com.wint.wintwealthgallery.core.Resource
import com.wint.wintwealthgallery.feature_node.domain.model.Album
import com.wint.wintwealthgallery.feature_node.domain.model.Media
import com.wint.wintwealthgallery.feature_node.domain.util.MediaOrder
import kotlinx.coroutines.flow.Flow

interface MediaRepository {

    fun getMedia(): Flow<Resource<List<Media>>>

    fun getFavorites(mediaOrder: MediaOrder): Flow<Resource<List<Media>>>

    fun getTrashed(mediaOrder: MediaOrder): Flow<Resource<List<Media>>>

    fun getAlbums(mediaOrder: MediaOrder): Flow<Resource<List<Album>>>

    suspend fun insertMedia(media: Media, callback: MediaScannerConnection.OnScanCompletedListener)

    suspend fun getMediaById(mediaId: Long): Media?

    fun getMediaByAlbumId(albumId: Long): Flow<Resource<List<Media>>>

    fun getMediaByUri(uriAsString: String): Flow<Resource<List<Media>>>

    suspend fun toggleFavorite(
        result: ActivityResultLauncher<IntentSenderRequest>,
        mediaList: List<Media>,
        favorite: Boolean
    )

    suspend fun trashMedia(
        result: ActivityResultLauncher<IntentSenderRequest>,
        mediaList: List<Media>,
        trash: Boolean
    )

    suspend fun deleteMedia(
        result: ActivityResultLauncher<IntentSenderRequest>,
        mediaList: List<Media>
    )

}