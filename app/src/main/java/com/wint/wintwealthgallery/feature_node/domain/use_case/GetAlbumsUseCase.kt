/*
 * SPDX-FileCopyrightText: 2023 IacobIacob01
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wint.wintwealthgallery.feature_node.domain.use_case

import com.wint.wintwealthgallery.core.Resource
import com.wint.wintwealthgallery.feature_node.domain.model.Album
import com.wint.wintwealthgallery.feature_node.domain.repository.MediaRepository
import com.wint.wintwealthgallery.feature_node.domain.util.MediaOrder
import com.wint.wintwealthgallery.feature_node.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAlbumsUseCase @Inject constructor(
    private val repository: MediaRepository
) {

    operator fun invoke(
        mediaOrder: MediaOrder = MediaOrder.Date(OrderType.Descending)
    ): Flow<Resource<List<Album>>> = repository.getAlbums(mediaOrder)
}