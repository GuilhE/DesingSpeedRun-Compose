package com.github.guilhe.mysoothe.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults.textButtonColors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.github.guilhe.mysoothe.R
import java.util.*

@Composable
fun WelcomeScreen(modifier: Modifier, onLogin: () -> Unit) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.background,
    ) {
        Image(
            painter = painterResource(
                id = if (isSystemInDarkTheme()) R.drawable.ic_dark_welcome else R.drawable.ic_light_welcome
            ),
            contentScale = ContentScale.FillBounds,
            contentDescription = null
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(
                    id = if (isSystemInDarkTheme()) R.drawable.ic_dark_logo else R.drawable.ic_light_logo
                ),
                contentDescription = null
            )
            Spacer(modifier = Modifier.padding(top = 32.dp))
            TextButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp),
                onClick = { },
                colors = textButtonColors(
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = MaterialTheme.colors.onPrimary
                ),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = stringResource(R.string.btn_signup).toUpperCase(Locale.getDefault()))
            }
            TextButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .height(72.dp),
                onClick = { onLogin.invoke() },
                colors = textButtonColors(
                    backgroundColor = MaterialTheme.colors.secondary,
                    contentColor = MaterialTheme.colors.onSecondary
                ),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = stringResource(R.string.btn_login).toUpperCase(Locale.getDefault()))
            }
        }
    }
}