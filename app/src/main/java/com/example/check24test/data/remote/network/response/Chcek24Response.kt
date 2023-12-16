package com.example.check24test.data.remote.network.response

import com.google.gson.annotations.SerializedName

data class RealEstateAdvertisementsResponse(
    @SerializedName("items")
    var items: List<RealEstateAdvertisement>?,
    @SerializedName("totalCount")
    var totalCount: Int,
)

data class RealEstateAdvertisement(
    @SerializedName("bedrooms")
    var bedrooms: Int?,
    @SerializedName("city")
    var city: String?,
    @SerializedName("id")
    var id: Int,
    @SerializedName("area")
    var area: Double?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("price")
    var price: Double?,
    @SerializedName("professional")
    var professional: String?,
    @SerializedName("propertyType")
    var propertyType: String?,
    @SerializedName("offerType")
    var offerType: Int?,
    @SerializedName("rooms")
    var rooms: Int?
)