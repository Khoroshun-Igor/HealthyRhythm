package com.tamago.healthyrhythm.ui.components.settingcard

import androidx.annotation.RawRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.LottieAnimationView
import com.tamago.healthyrhythm.R
import com.tamago.healthyrhythm.ui.components.animation.Loader
import com.tamago.healthyrhythm.ui.theme.AppTheme

/**
 * Created by Igor Khoroshun on 03.02.2024.
 */

@Composable
fun SettingCard(
    text: String,
    @RawRes res: Int,
    modifier: Modifier = Modifier
){
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.max_padding))
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center

        ) {
            Loader(
                res = res
            )
            Text(
                text = text,
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun SettingCardPreview(){
    AppTheme {
        SettingCard(
            "abc",
            res = R.raw.rythm_of_breath
        )
    }
}