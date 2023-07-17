package com.berg.rickapp.data.mapper

import com.berg.rickapp.core.common.mapper.Mapper
import com.berg.rickapp.data.dto.CharacterDto
import com.berg.rickapp.domain.model.Character
import com.berg.rickapp.domain.model.UrlSchemeModel

interface CharacterMapper : Mapper<CharacterDto, Character>

class DefaultCharacterMapper : CharacterMapper {

    override fun map(input: CharacterDto): Character {
        return Character(
            id = input.id ?: -1,
            name = input.name ?: "",
            status = input.status ?: "",
            species = input.species ?: "",
            type = input.type ?: "",
            gender = input.gender ?: "",
            origin = UrlSchemeModel(
                name = input.origin?.name ?: "",
                url = input.origin?.url ?: "",
            ),
            location = UrlSchemeModel(
                name = input.location?.name ?: "",
                url = input.location?.url ?: "",
            ),
            image = input.image ?: "",
            episodeList = input.episodeList?.map{ it } ?: emptyList(),
            url = input.url ?: "",
            created = input.created ?: "",
        )
    }
}