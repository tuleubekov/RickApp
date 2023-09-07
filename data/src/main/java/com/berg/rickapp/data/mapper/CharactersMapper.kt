package com.berg.rickapp.data.mapper

import com.berg.rickapp.common.utils.Mapper
import com.berg.rickapp.data.dto.CharacterDto
import com.berg.rickapp.data.dto.CharacterListDto
import com.berg.rickapp.domain.model.Character
import com.berg.rickapp.domain.model.CharacterList
import com.berg.rickapp.domain.model.CharacterListInfo
import com.berg.rickapp.domain.model.UrlSchemeModel

interface CharactersMapper : Mapper<CharacterListDto, CharacterList>

class DefaultCharactersMapper : CharactersMapper {

    override fun map(input: CharacterListDto): CharacterList {
        return CharacterList(
            pageInfo = CharacterListInfo(
                count = input.info?.count ?: 0,
                pages = input.info?.pages ?: 0,
                next = input.info?.next ?: "",
                prev = input.info?.prev ?: ""
            ),
            characters = input.results?.map(::mapToCharacter) ?: emptyList()
        )
    }

    private fun mapToCharacter(dto: CharacterDto): Character {
        return Character(
            id = dto.id ?: -1,
            name = dto.name ?: "",
            status = dto.status ?: "",
            species = dto.species ?: "",
            type = dto.type ?: "",
            gender = dto.gender ?: "",
            origin = UrlSchemeModel(
                name = dto.origin?.name ?: "",
                url = dto.origin?.url ?: "",
            ),
            location = UrlSchemeModel(
                name = dto.location?.name ?: "",
                url = dto.location?.url ?: "",
            ),
            image = dto.image ?: "",
            episodeList = dto.episodeList?.map{ it } ?: emptyList(),
            url = dto.url ?: "",
            created = dto.created ?: "",
        )
    }
}