package com.tamago.healthyrhythm.ui.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.tamago.healthyrhythm.R

/**
 * Created by Igor Khoroshun on 27.01.2024.
 */

@Composable
fun MainButton(
    value: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Button(
        onClick = onClick,
        modifier = modifier
            .padding(dimensionResource(R.dimen.max_padding))
            .fillMaxWidth()
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.headlineLarge
        )
    }
}