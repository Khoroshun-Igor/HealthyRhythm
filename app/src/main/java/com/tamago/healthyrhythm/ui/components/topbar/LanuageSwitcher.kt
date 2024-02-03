package com.tamago.healthyrhythm.ui.components.topbar

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tamago.healthyrhythm.R
import com.tamago.healthyrhythm.data.managers.LanguageManager
import com.tamago.healthyrhythm.ui.theme.AppTheme

/**
 * Created by Igor Khoroshun on 03.12.2023.
 */

@Composable
fun LanguageSwitcher(
    currentLanguage: LanguageManager.Language,
    onSwitchLangAction: (LanguageManager.Language) -> Unit,
    modifier: Modifier = Modifier
) {
    var isExpended by remember {
        mutableStateOf(false)
    }
    val langMode = remember {
        mutableStateOf(currentLanguage)
    }
    
    LaunchedEffect(key1 = langMode.value, block = { onSwitchLangAction.invoke(langMode.value) })

    Card {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Column {
                Image(
                    painter = painterResource(
                        if (langMode.value == LanguageManager.Language.RU)
                            R.drawable.flag_ru
                        else
                            R.drawable.flag_us
                    ),
                    contentDescription = stringResource(R.string.language),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.small_padding))
                        .size(dimensionResource(R.dimen.avatar_size))
                        .clip(CircleShape)
                        .clickable { isExpended = !isExpended }
                )
            }
            if (isExpended) {
                Column {
                    Image(
                        painter = painterResource(
                            if (langMode.value == LanguageManager.Language.RU)
                                R.drawable.flag_us
                            else
                                R.drawable.flag_ru
                        ),
                        contentDescription = stringResource(R.string.language),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(dimensionResource(R.dimen.small_padding))
                            .size(dimensionResource(R.dimen.avatar_size))
                            .clip(CircleShape)
                            .clickable {
                                langMode.value =
                                    if (langMode.value == LanguageManager.Language.EN)
                                        LanguageManager.Language.RU
                                    else
                                        LanguageManager.Language.EN
                                isExpended = !isExpended
                            }
                    )
                }
            }
        }
    }
}