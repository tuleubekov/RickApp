package com.berg.rickapp.common.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

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

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AppImage(path: String?) {
    GlideImage(
        model = path,
        //loading = placeholder(R.drawable.avatar_unknown),
        contentDescription = "",
        modifier = Modifier.clip(RoundedCornerShape(8.dp)),
    )
}