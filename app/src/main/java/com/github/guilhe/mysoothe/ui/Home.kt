package com.github.guilhe.mysoothe.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.guilhe.mysoothe.R
import com.github.guilhe.mysoothe.ui.theme.FabTheme
import com.github.guilhe.mysoothe.ui.theme.TextInputTheme
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.insets.systemBarsPadding
import java.util.Locale

sealed class BottomNavigationScreens(@StringRes val resourceId: Int, val icon: ImageVector) {
    object Home : BottomNavigationScreens(R.string.nav_home, Icons.Filled.Spa)
    object Profile : BottomNavigationScreens(R.string.nav_profile, Icons.Filled.AccountCircle)
}

data class Item(val name: String, val imageUrl: String = "")

@Composable
fun HomeScreen(modifier: Modifier) {
    var search by rememberSaveable { mutableStateOf("") }
    val navItems = listOf(BottomNavigationScreens.Home, BottomNavigationScreens.Profile)
    val collectionItems = listOf(
        Item("Short mantras", "https://images.pexels.com/photos/5410875/pexels-photo-5410875.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
        Item("Nature meditations", "https://images.pexels.com/photos/3571551/pexels-photo-3571551.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
        Item("Stress and anxiety", "https://images.pexels.com/photos/1557238/pexels-photo-1557238.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
        Item("Self-massage", "https://images.pexels.com/photos/1029604/pexels-photo-1029604.jpeg"),
        Item("Overwhelmed", "https://images.pexels.com/photos/3560044/pexels-photo-3560044.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
        Item("Nightly wind down", "https://images.pexels.com/photos/924824/pexels-photo-924824.jpeg")
    )
    val bodyItems = listOf(
        Item("Inversions", "https://images.pexels.com/photos/317157/pexels-photo-317157.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
        Item("Quick yoga", "https://images.pexels.com/photos/1812964/pexels-photo-1812964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
        Item("Streching", "https://images.pexels.com/photos/4056723/pexels-photo-4056723.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
        Item("Tabata", "https://images.pexels.com/photos/4662438/pexels-photo-4662438.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
        Item("HIIT", "https://images.pexels.com/photos/999309/pexels-photo-999309.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
        Item("Pre-natal yoga", "https://images.pexels.com/photos/396133/pexels-photo-396133.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260")
    )
    val mindItems = listOf(
        Item("Meditate", "https://images.pexels.com/photos/3822622/pexels-photo-3822622.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
        Item("With Kids", "https://images.pexels.com/photos/3094230/pexels-photo-3094230.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
        Item("Aromatherapy", "https://images.pexels.com/photos/4498318/pexels-photo-4498318.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
        Item("On the go", "https://images.pexels.com/photos/1241348/pexels-photo-1241348.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
        Item("With pets", "https://images.pexels.com/photos/4056535/pexels-photo-4056535.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
        Item("High stress", "https://images.pexels.com/photos/897817/pexels-photo-897817.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260")
    )

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            modifier = modifier
                .fillMaxSize()
                .systemBarsPadding(),
            bottomBar = {
                BottomNavigation(backgroundColor = MaterialTheme.colors.background) {
                    navItems.forEach {
                        BottomNavigationItem(
                            icon = {
                                Image(
                                    imageVector = it.icon,
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground),
                                    modifier = Modifier.size(18.dp)
                                )
                            },
                            label = {
                                Text(
                                    text = stringResource(id = it.resourceId).toUpperCase(Locale.getDefault()),
                                    style = MaterialTheme.typography.caption,
                                    color = MaterialTheme.colors.onBackground
                                )
                            },
                            selected = it == BottomNavigationScreens.Home,
                            onClick = { }
                        )
                    }
                }
            },
            floatingActionButton = {
                FabTheme {
                    FloatingActionButton(onClick = {}) {
                        Image(
                            imageVector = Icons.Filled.PlayArrow,
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(MaterialTheme.colors.onSecondary),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            },
            isFloatingActionButtonDocked = true,
            floatingActionButtonPosition = FabPosition.Center,
            backgroundColor = MaterialTheme.colors.background
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(top = 52.dp, bottom = 100.dp)
            ) {
                item {
                    TextInputTheme {
                        TextField(
                            value = search,
                            onValueChange = { search = it },
                            textStyle = MaterialTheme.typography.body1,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, end = 16.dp)
                                .height(56.dp),
                            leadingIcon = { Icon(imageVector = Icons.Filled.Search, modifier = Modifier.size(18.dp), contentDescription = null) },
                            label = { Text(text = stringResource(R.string.hint_search)) },
                            colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.onSecondary)
                        )
                    }
                }
                item {
                    Text(
                        text = stringResource(R.string.lbl_favorite).toUpperCase(Locale.getDefault()),
                        modifier = Modifier.padding(start = 16.dp, top = 40.dp),
                        style = MaterialTheme.typography.h2,
                        color = MaterialTheme.colors.onBackground
                    )
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        contentPadding = PaddingValues(start = 12.dp, end = 12.dp)
                    ) {
                        collectionItems.chunked(2).forEach { item { RectItem(it) } }
                    }
                }
                item {
                    Column {
                        Text(
                            stringResource(R.string.lbl_body).toUpperCase(Locale.getDefault()),
                            modifier = Modifier.padding(start = 16.dp, top = 40.dp),
                            style = MaterialTheme.typography.h2,
                            color = MaterialTheme.colors.onBackground
                        )
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            contentPadding = PaddingValues(start = 12.dp, end = 12.dp)
                        ) {
                            bodyItems.forEach { item { CircularItem(it) } }
                        }
                    }
                }
                item {
                    Column {
                        Text(
                            stringResource(R.string.lbl_mind).toUpperCase(Locale.getDefault()),
                            modifier = Modifier.padding(start = 16.dp, top = 40.dp),
                            style = MaterialTheme.typography.h2,
                            color = MaterialTheme.colors.onBackground
                        )
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            contentPadding = PaddingValues(start = 12.dp, end = 12.dp)
                        ) {
                            mindItems.forEach { item { CircularItem(it) } }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun RectItem(item: List<Item>) {
    Column {
        item.forEach {
            Card(
                modifier = Modifier
                    .size(192.dp, 56.dp)
                    .padding(4.dp),
                shape = MaterialTheme.shapes.small
            ) {
                Row(Modifier.background(MaterialTheme.colors.surface), verticalAlignment = Alignment.CenterVertically) {
                    CoilImage(
                        data = it.imageUrl,
                        modifier = Modifier.size(56.dp),
                        fadeIn = true,
                        contentScale = ContentScale.FillBounds,
                        contentDescription = it.name,
                        loading = {
                            Box(Modifier.matchParentSize()) {
                                CircularProgressIndicator(Modifier.align(Alignment.Center))
                            }
                        },
                    )
                    Text(
                        text = it.name,
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(start = 16.dp),
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.h3
                    )
                }
            }
        }
    }
}

@Composable
private fun CircularItem(item: Item) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(start = 4.dp, end = 4.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CoilImage(
            data = item.imageUrl,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            fadeIn = true,
            contentDescription = item.name,
            loading = {
                Box(Modifier.matchParentSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            },
        )
        Text(
            text = item.name,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h3
        )
    }
}