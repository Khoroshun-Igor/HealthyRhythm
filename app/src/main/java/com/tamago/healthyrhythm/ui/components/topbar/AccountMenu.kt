package com.tamago.healthyrhythm.ui.components.topbar

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tamago.healthyrhythm.R
import com.tamago.healthyrhythm.ui.main.HealthyRhythmViewModel
import com.tamago.healthyrhythm.ui.navigation.AppNavigationAction
import com.tamago.healthyrhythm.ui.theme.AppTheme

/**
 * Created by Igor Khoroshun on 03.12.2023.
 */

@Composable
fun AccountMenu(
    viewModel: HealthyRhythmViewModel,
    navigationAction: AppNavigationAction? = null
) {
    val userName = viewModel.authManager.currentUser?.displayName
    var showDialog by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier.width(dimensionResource(R.dimen.option_w))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessVeryLow
                    )
                )
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = dimensionResource(R.dimen.small_padding))
                    .clickable {
                        showDialog = !showDialog
                    }
            ) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = stringResource(R.string.profile),
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.small_padding))
                        .size(dimensionResource(R.dimen.avatar_size))
                )
                Spacer(modifier = Modifier.size(dimensionResource(R.dimen.small_padding)))
                Text(
                    text = userName ?: stringResource(R.string.guest),
                    modifier = Modifier.padding(dimensionResource(R.dimen.small_padding))
                )
            }
            if (showDialog) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    TextButton(
                        onClick = {
                            navigationAction?.navigateToSignUp()
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = stringResource(R.string.sign_up)
                        )
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (userName == null) {
                        TextButton(
                            onClick = {
                                navigationAction?.navigateToSignIn()
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = stringResource(R.string.sign_in)
                            )
                        }
                    }else{
                        TextButton(
                            onClick = {
                                viewModel.authManager.signOut()
                                navigationAction?.navigateToSignIn()
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = stringResource(R.string.sign_out)
                            )
                        }
                    }
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun AccountMenuPreview(){
//    AppTheme {
//        AccountMenu()
//    }
//}