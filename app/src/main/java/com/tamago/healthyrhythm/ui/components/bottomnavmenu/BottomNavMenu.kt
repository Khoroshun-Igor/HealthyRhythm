package com.tamago.healthyrhythm.ui.components.bottomnavmenu

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.tamago.healthyrhythm.R
import com.tamago.healthyrhythm.app.Constants
import com.tamago.healthyrhythm.ui.navigation.AppNavigationAction
import com.tamago.healthyrhythm.ui.theme.AppTheme

/**
 * Created by Igor Khoroshun on 27.01.2024.
 */
@Composable
fun BottomNavMenu(
    modifier: Modifier = Modifier,
    navigationAction: AppNavigationAction? = null
){
    val openBrowser = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
        onResult = {}
    )

    NavigationBar(
        modifier = modifier
            .fillMaxWidth()
    ) {
        NavigationBarItem(
            label = {
                    Text(
                        text = stringResource(R.string.back),
                    )
            },
            selected = true,
            onClick = { navigationAction?.back() },
            icon = {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back),
                    modifier = modifier
                        .size(dimensionResource(R.dimen.avatar_size))
                )
            }
        )
        NavigationBarItem(
            label = {
                Text(stringResource(R.string.contacts))
            },
            selected = true,
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(Constants.URL_HEALTH))
                openBrowser.launch(intent)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = stringResource(R.string.contacts),
                    modifier = modifier
                        .size(dimensionResource(R.dimen.avatar_size))
                )
            }
        )
        NavigationBarItem(
            label = {
                Text(stringResource(R.string.results))
            },
            selected = true,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = stringResource(R.string.results),
                    modifier = modifier
                        .size(dimensionResource(R.dimen.avatar_size))
                )
            }
        )
    }
}

@Preview
@Composable
fun BottomNavMenuPreview(){
    AppTheme {
        BottomNavMenu()
    }
}