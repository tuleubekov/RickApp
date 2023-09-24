package com.berg.rickapp.common.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun AppBar() = TopAppBar(
    title = { Text(text = "Rick") },
    backgroundColor = Color.White,
    contentColor = Color.Black,
)

@Composable
fun AppButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(modifier = modifier, onClick = { onClick() }) {
        Text(text = text)
    }
}

@Composable
fun AppImage(path: String?) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(path)
            .crossfade(300)
            .build(),
        placeholder = painterResource(R.drawable.avatar_unknown),
        contentDescription = "",
        modifier = Modifier.clip(RoundedCornerShape(8.dp)),
    )
}