package com.tamago.healthyrhythm.ui.components.settingcard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import com.tamago.healthyrhythm.R

/**
 * Created by Igor Khoroshun on 03.02.2024.
 */

@Composable
fun SettingCard(
    text: String,
    image: ImageVector,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.max_padding))
    ){
        Row {
            Image(
                imageVector = image,
                contentDescription = text,
                modifier = modifier
                    .size(dimensionResource(R.dimen.option_h))
            )
            Text(
                text = text,
                style = MaterialTheme.typography.headlineLarge
            )
        }
    }
}