package com.tamago.healthyrhythm.ui.components.animation

import androidx.annotation.RawRes
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.tamago.healthyrhythm.R

/**
 * Created by Igor Khoroshun on 11.02.2024.
 */

@Composable
fun Loader(
    @RawRes res: Int
){
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(res)
    )
    val progress by animateLottieCompositionAsState(composition)
    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier
            .size(dimensionResource(id = R.dimen.option_h))
    )
}