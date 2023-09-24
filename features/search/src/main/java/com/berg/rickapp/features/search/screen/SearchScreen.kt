@file:OptIn(ExperimentalMaterialApi::class)

package com.berg.rickapp.features.search.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.berg.rickapp.common.ui.AppBar
import com.berg.rickapp.domain.model.Character
import com.berg.rickapp.features.search.SearchViewModel
import com.berg.rickapp.features.search.screen.component.ErrorMessage
import com.berg.rickapp.features.search.screen.component.LoadingNextPageItem
import com.berg.rickapp.features.search.screen.component.PageLoader
import kotlinx.coroutines.flow.flowOf

@Composable
fun SearchScreenRoot(
    viewModel: SearchViewModel,
) {
    val pagingCharacters = viewModel.statePagerCharacters.collectAsLazyPagingItems()
    val refreshing by viewModel.isRefreshing.collectAsState()

    val refreshState = rememberPullRefreshState(
        refreshing = refreshing,
        onRefresh = { viewModel.retry() }
    )

    SearchScreen(
        items = pagingCharacters,
        refreshing = refreshing,
        pullRefreshState = refreshState,
        retry = { viewModel.retry() },
    )
}

@Composable
fun SearchScreen(
    items: LazyPagingItems<Character>,
    refreshing: Boolean = false,
    pullRefreshState: PullRefreshState,
    retry: () -> Unit = {},
) {
    Scaffold(
        topBar = { AppBar() },
        content = { padding ->
            Box(modifier = Modifier.pullRefresh(pullRefreshState)) {
                LazyColumn (
                    contentPadding = PaddingValues(padding.calculateTopPadding() + 16.dp),
                ) {
                    items(items.itemCount) { idx -> CharacterItem(itemEntity = items[idx]) }
                    items.apply { stateOfPagingItems(items, retry) }
                }
                PullRefreshIndicator(
                    refreshing = refreshing,
                    state = pullRefreshState,
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }
        }
    )
}

private fun LazyListScope.stateOfPagingItems(
    items: LazyPagingItems<Character>,
    retry: () -> Unit = {},
) {
    items.apply {
        when {
            loadState.refresh is LoadState.Loading -> {
                item { PageLoader(modifier = Modifier.fillParentMaxSize()) }
            }
            loadState.refresh is LoadState.Error -> {
                val error = items.loadState.refresh as LoadState.Error
                item {
                    ErrorMessage(
                        message = error.error.message ?: "Error",
                        modifier = Modifier.fillParentMaxSize(),
                        onClickRetry = { retry.invoke() }
                    )
                }
            }
            loadState.append is LoadState.Loading -> {
                item { LoadingNextPageItem(modifier = Modifier) }
            }
            loadState.append is LoadState.Error -> {
                val error = items.loadState.refresh as LoadState.Error
                item {
                    ErrorMessage(
                        message = error.error.message ?: "Error",
                        modifier = Modifier.fillParentMaxSize(),
                        onClickRetry = { retry.invoke() }
                    )
                }
            }
        }
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
    SearchScreen(
        items = flowOf(PagingData.empty<Character>()).collectAsLazyPagingItems(),
        pullRefreshState = rememberPullRefreshState(refreshing = false, onRefresh = {}),
    )
}