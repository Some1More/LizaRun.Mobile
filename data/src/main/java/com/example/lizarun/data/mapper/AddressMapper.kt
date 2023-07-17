package com.example.lizarun.data.mapper

import com.example.lizarun.data.storage.model.request.AddressRequest
import com.example.lizarun.data.storage.model.response.AddressResponse
import com.example.lizarun.domain.model.entity.Address
import com.example.lizarun.domain.model.param.CreateAddressParam

fun AddressResponse.mapToDomain(): Address {
    return Address(
        region = region,
        city = city
    )
}

fun CreateAddressParam.mapToStorage(): AddressRequest {
    return AddressRequest(
        region = region,
        city = city
    )
}