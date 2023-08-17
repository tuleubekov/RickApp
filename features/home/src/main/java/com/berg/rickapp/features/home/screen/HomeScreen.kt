package com.berg.rickapp.features.home.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.berg.rickapp.features.home.HomeViewModel

@Composable
fun HomeScreenRoot(
    viewModel: HomeViewModel,
) {
    val name by viewModel.mStateCharacter.collectAsState()
    HomeScreen(
        name = name,
        goto = { viewModel.gotoDetails() },
        gotoAbout = { viewModel.gotoAbout() }
    )
}

@Composable
fun HomeScreen(
    name: String,
    goto: () -> Unit = {},
    gotoAbout: () -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(fontSize = 20.sp, text = name)
        Button(onClick = { goto() }) {
            Text(text = "Go to Details")
        }
        Button(onClick = { gotoAbout() }) {
            Text(text = "Go to About")
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen("Rick")
}