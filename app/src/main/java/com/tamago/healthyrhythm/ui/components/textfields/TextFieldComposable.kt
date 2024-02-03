package com.tamago.healthyrhythm.ui.components.textfields

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.tamago.healthyrhythm.R

/**
 * Created by Igor Khoroshun on 06.12.2023.
 */

@Composable
fun NameField(
    value: String,
    onNewValue: (String) -> Unit,
    modifier: Modifier = Modifier
){
    OutlinedTextField(
        value = value,
        onValueChange = { onNewValue(it) },
        singleLine = true,
        placeholder = { Text(text = stringResource(R.string.name)) },
        leadingIcon = { Icon(imageVector = Icons.Default.Face, contentDescription = stringResource(R.string.name))},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        modifier = modifier
            .padding(dimensionResource(R.dimen.medium_padding))
    )
}
@Composable
fun EmailField(
    value: String,
    onNewValue: (String) -> Unit,
    modifier: Modifier = Modifier
){
    OutlinedTextField(
        value = value,
        onValueChange = { onNewValue(it) },
        singleLine = true,
        placeholder = { Text(text = stringResource(R.string.email)) },
        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = stringResource(R.string.email)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        modifier = modifier
            .padding(dimensionResource(R.dimen.medium_padding))
    )
}

@Composable
fun PasswordField(
    value: String,
    onNewValue: (String) -> Unit,
    modifier: Modifier = Modifier
){
    PasswordField(value = value, placeholder = R.string.password, onNewValue = onNewValue)
}

@Composable
fun RepeatPasswordField(
    value: String,
    onNewValue: (String) -> Unit,
    modifier: Modifier = Modifier
){
    PasswordField(value = value, placeholder = R.string.repeat_password, onNewValue = onNewValue)
}

@Composable
fun PasswordField(
    value: String,
    @StringRes placeholder: Int,
    onNewValue: (String) -> Unit,
    modifier: Modifier = Modifier
){
    var isVisible by remember {
        mutableStateOf(false)
    }

    val icon =
        if(isVisible) painterResource(R.drawable.baseline_visibility_24)
        else painterResource(R.drawable.baseline_visibility_off_24)

    val visualTransformation =
        if(isVisible) VisualTransformation.None else PasswordVisualTransformation()

    OutlinedTextField(
        value = value,
        onValueChange = { onNewValue(it) },
        singleLine =  true,
        placeholder = { Text(text = stringResource(placeholder)) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = stringResource(R.string.password)
            )
        },
        trailingIcon = {
            IconButton(onClick = { isVisible = !isVisible }) {
                Icon(painter = icon, contentDescription = stringResource(R.string.password))
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = visualTransformation,
        modifier = modifier
            .padding(dimensionResource(R.dimen.medium_padding))
    )
}