/*
 * SPDX-FileCopyrightText: 2023 IacobIacob01
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wint.wintwealthgallery.feature_node.domain.use_case

import com.wint.wintwealthgallery.core.Resource
import com.wint.wintwealthgallery.feature_node.domain.model.Media
import com.wint.wintwealthgallery.feature_node.domain.repository.MediaRepository
import kotlinx.coroutines.flow.Flow

class GetMediaByUriUseCase(
    private val repository: MediaRepository
) {
    operator fun invoke(
        uriAsString: String,
    ): Flow<Resource<List<Media>>> {
        return repository.getMediaByUri(uriAsString)
    }

}

