/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.guilhe.mysoothe.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.github.guilhe.mysoothe.R
import com.github.guilhe.mysoothe.ui.theme.TextInputTheme
import java.util.Locale

@Composable
fun LoginScreen(modifier: Modifier, onLogin: () -> Unit) {
    var email by rememberSaveable { mutableStateOf("") }
    var pwd by rememberSaveable { mutableStateOf("") }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Image(
            painter = painterResource(
                id = if (isSystemInDarkTheme()) R.drawable.ic_dark_login else R.drawable.ic_light_login
            ),
            contentScale = ContentScale.FillBounds,
            contentDescription = null
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.btn_login).toUpperCase(Locale.getDefault()),
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.padding(top = 32.dp))
            TextInputTheme {
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    textStyle = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    label = { Text(text = stringResource(R.string.hint_email)) },
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.onSecondary)
                )
            }
            TextInputTheme {
                TextField(
                    value = pwd,
                    onValueChange = { pwd = it },
                    textStyle = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .height(56.dp),
                    label = { Text(text = stringResource(R.string.hint_pwd)) },
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.onSecondary)
                )
            }
            TextButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .height(72.dp),
                onClick = { onLogin.invoke() },
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = MaterialTheme.colors.onPrimary
                ),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = stringResource(R.string.btn_login).toUpperCase(Locale.getDefault()))
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Text(text = stringResource(R.string.lbl_no_account))
                Text(
                    text = stringResource(R.string.btn_signup),
                    style = TextStyle(textDecoration = TextDecoration.Underline)
                )
            }
        }
    }
}
