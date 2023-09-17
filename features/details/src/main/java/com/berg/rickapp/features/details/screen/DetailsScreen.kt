package com.berg.rickapp.features.details.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.berg.rickapp.common.ui.AppButton
import com.berg.rickapp.features.details.DetailsViewModel

@Composable
fun DetailsScreenRoot(
    viewModel: DetailsViewModel,
    back: () -> Unit = {}
) {
    val name by viewModel.mStateCharacter.collectAsState()
    DetailsScreen(name, back)
}

@Composable
fun DetailsScreen(
    name: String,
    back: () -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(fontSize = 20.sp, text = name)
        Text(fontSize = 20.sp, text = "DETAILS SCREEN")
        AppButton(text = "back") { back() }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    DetailsScreen(name = "Rick")
}