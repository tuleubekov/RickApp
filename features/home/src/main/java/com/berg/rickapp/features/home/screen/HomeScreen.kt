@file:OptIn(ExperimentalMaterialApi::class)

package com.berg.rickapp.features.home.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.PullRefreshState
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.berg.rickapp.common.ui.AppBar
import com.berg.rickapp.common.ui.AppImage
import com.berg.rickapp.domain.model.Character
import com.berg.rickapp.features.home.HomeViewModel

@Composable
fun HomeScreenRoot(
    viewModel: HomeViewModel,
) {
    val pagingCharacters = viewModel.stateRandomCharacters.collectAsState()
    val refreshing by viewModel.isRefreshing.collectAsState()

    val refreshState = rememberPullRefreshState(
        refreshing = refreshing,
        onRefresh = { viewModel.retry() }
    )

    HomeScreen(
        items = pagingCharacters.value,
        pullRefreshState = refreshState,
    )
}

@Composable
fun HomeScreen(
    items: List<Character>,
    refreshing: Boolean = false,
    pullRefreshState: PullRefreshState,
) {
    Scaffold(
        topBar = { AppBar() },
        content = { padding ->
            Box(modifier = Modifier.pullRefresh(pullRefreshState)) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(padding.calculateTopPadding() + 16.dp),
                ) {
                    items(items) {
                        CharacterItem(itemEntity = it)
                    }
                }
                PullRefreshIndicator(refreshing, pullRefreshState, Modifier.align(Alignment.TopCenter))
            }
        }
    )
}

@Composable
fun CharacterItem(
    itemEntity: Character?,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AppImage(path = itemEntity?.image,)
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            text = itemEntity?.name ?: "---",
            fontSize = 20.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.padding(4.dp))
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        items = emptyList(),
        pullRefreshState = rememberPullRefreshState(refreshing = false, onRefresh = {})
    )
}