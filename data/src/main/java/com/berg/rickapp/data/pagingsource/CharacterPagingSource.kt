package com.berg.rickapp.data.pagingsource

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.berg.rickapp.data.datasource.RemoteDataSource
import com.berg.rickapp.domain.model.Character
import retrofit2.HttpException
import java.io.IOException

class CharacterPagingSource constructor(
    private val remoteDataSource: RemoteDataSource,
) : PagingSource<Int, Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val result = remoteDataSource.getCharacters(params.key ?: 1)
            LoadResult.Page(
                data = result.characters,
                prevKey = result.pageInfo.prev.pageKey(),
                nextKey = result.pageInfo.next.pageKey(),
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition
    }

    private fun String?.pageKey(): Int? {
        return Uri.parse(this).getQueryParameter("page")?.toIntOrNull()
    }

    companion object {
        const val PAGE_SIZE = Int.MAX_VALUE
        const val PREFETCH_DISTANCE = 2
    }
}