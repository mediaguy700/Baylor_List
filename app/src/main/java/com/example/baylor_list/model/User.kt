package com.example.baylor_list.model





data class User (
    val name: String,
    val email: String,
    val username: String,
    val phone: String,
    val website: String,
    val address: Address,
    val company: Company



)

data class Company(
    val name: String,
    val catchPhrase: String


)



data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geo

)

data class Geo(
    val lat: String,
    val lng: String

)
