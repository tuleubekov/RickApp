package com.berg.rickapp.features.home.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.berg.rickapp.common.ui.AppButton
import com.berg.rickapp.domain.model.Character
import com.berg.rickapp.features.home.HomeViewModel
import kotlinx.coroutines.flow.flowOf

@Composable
fun HomeScreenRoot(
    viewModel: HomeViewModel,
) {
    val pagingCharacters = viewModel.statePagerCharacters.collectAsLazyPagingItems()
    HomeScreen(
        items = pagingCharacters,
        retry = { viewModel.retry() },
        goto = { viewModel.gotoDetails() }
    )
}

@Composable
fun HomeScreen(
    items: LazyPagingItems<Character>,
    retry: () -> Unit = {},
    goto: () -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(fontSize = 20.sp, text = "HOME FRAGMENT")
        AppButton(text = "Goto") { goto() }
    }
}

@Composable
fun CharacterItem(
    itemEntity: Character?,
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Color.Black)
            .padding(16.dp),
        fontSize = 20.sp, text = itemEntity?.name ?: "---",
    )
    Spacer(modifier = Modifier.padding(4.dp))
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        items = flowOf(PagingData.empty<Character>()).collectAsLazyPagingItems()
    )
}