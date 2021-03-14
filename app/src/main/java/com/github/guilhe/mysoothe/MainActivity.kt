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
package com.github.guilhe.mysoothe

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.github.guilhe.mysoothe.ui.HomeScreen
import com.github.guilhe.mysoothe.ui.LoginScreen
import com.github.guilhe.mysoothe.ui.WelcomeScreen
import com.github.guilhe.mysoothe.ui.theme.AppTheme
import dev.chrisbanes.accompanist.insets.ExperimentalAnimatedInsets
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object Login : Screen("login")
    object Home : Screen("home")
}

class MainActivity : AppCompatActivity() {
    @ExperimentalAnimatedInsets
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            AppTheme {
                ProvideWindowInsets {
                    Soothe(Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun Soothe(modifier: Modifier) {
    val controller = rememberNavController()
    NavHost(navController = controller, startDestination = Screen.Welcome.route) {
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(modifier) {
                controller.navigate(Screen.Login.route)
            }
        }
        composable(route = Screen.Login.route) {
            LoginScreen(modifier) {
                controller.popBackStack()
                controller.popBackStack()
                controller.navigate(Screen.Home.route)
            }
        }
        composable(route = Screen.Home.route) { HomeScreen(modifier) }
    }
}
