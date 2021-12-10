package com.example.chicko.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ProviderItem(
    @StringRes val titleRId: Int,
    @DrawableRes val BannerRid: Int
)