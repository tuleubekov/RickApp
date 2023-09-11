package com.berg.rickapp.features.search.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
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
    SearchScreen(
        items = pagingCharacters,
        retry = { viewModel.retry() },
    )
}

@Composable
fun SearchScreen(
    items: LazyPagingItems<Character>,
    retry: () -> Unit = {},
) {
    LazyColumn {
        items(items.itemCount) { idx -> CharacterItem(itemEntity = items[idx]) }
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
        items = flowOf(PagingData.empty<Character>()).collectAsLazyPagingItems()
    )
}