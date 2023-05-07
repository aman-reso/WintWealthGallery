/*
 * SPDX-FileCopyrightText: 2023 IacobIacob01
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wint.wintwealthgallery.feature_node.domain.util

sealed class OrderType {
    object Ascending : OrderType()
    object Descending : OrderType()
}
