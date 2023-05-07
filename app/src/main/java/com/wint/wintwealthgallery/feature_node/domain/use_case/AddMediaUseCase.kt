/*
 * SPDX-FileCopyrightText: 2023 IacobIacob01
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wint.wintwealthgallery.feature_node.domain.use_case

import com.wint.wintwealthgallery.feature_node.domain.model.InvalidMediaException
import com.wint.wintwealthgallery.feature_node.domain.model.Media
import com.wint.wintwealthgallery.feature_node.domain.repository.MediaRepository

class AddMediaUseCase(
    private val repository: MediaRepository
) {

    @Throws(InvalidMediaException::class)
    suspend operator fun invoke(media: Media) {
        if (media.path.isBlank())
            throw InvalidMediaException("${media.label} cannot be validated!")
        repository.insertMedia(media) { path, uri ->
            /* TODO */
        }
    }
}