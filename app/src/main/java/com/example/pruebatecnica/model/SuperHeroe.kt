package com.example.pruebatecnica.model

import com.google.gson.annotations.SerializedName

data class SuperHeroe (
    val response: String,
    val id: String,
    val name: String,
    val powerstats: Powerstats,
    val biography: Biography,
    val appearance: Appearance,
    val work: Work,
    val connections: Connections,
    val image: Image
)

data class Appearance (
    val gender: String,
    val race: String,
    val height: List<String>,
    val weight: List<String>,
    @SerializedName("eye-color")
    val eyeColor: String,
    @SerializedName("hair-color")
    val hairColor: String
)

data class Biography (
    @SerializedName("full-name")
    val fullName: String,
    @SerializedName("alter-egos")
    val alterEgos: String,
    val aliases: List<String>,
    @SerializedName("place-of-birth")
    val placeOfBirth: String,
    @SerializedName("first-appearance")
    val firstAppearance: String,
    val publisher: String,
    val alignment: String
)

data class Connections (
    @SerializedName("group-affiliation")
    val groupAffiliation: String,
    val relatives: String
)

data class Image (
    val url: String
)

data class Powerstats (
    val intelligence: String,
    val strength: String,
    val speed: String,
    val durability: String,
    val power: String,
    val combat: String
)

data class Work (
    val occupation: String,
    val base: String
)

