package com.example.lizarun.data.mapper

import com.example.lizarun.data.storage.model.response.AuthorResponse
import com.example.lizarun.domain.model.entity.Author

fun AuthorResponse.mapToDomain(): Author {
    return Author(
        id = id,
        firstname = firstname,
        middlename = middlename,
        photo = photo
    )
}