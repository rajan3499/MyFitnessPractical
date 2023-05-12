package com.myfitness.service.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserModel(
    @SerializedName("results")
    var results: List<Result> = listOf(),
    @SerializedName("info")
    var info: Info = Info()
): Serializable

data class Result(
    @SerializedName("gender")
    var gender: String = "", // male
    @SerializedName("name")
    var name: Name = Name(),
    @SerializedName("location")
    var location: Location = Location(),
    @SerializedName("email")
    var email: String = "", // zlatko.rodic@example.com
    @SerializedName("login")
    var login: Login = Login(),
    @SerializedName("dob")
    var dob: Dob = Dob(),
    @SerializedName("registered")
    var registered: Registered = Registered(),
    @SerializedName("phone")
    var phone: String = "", // 027-6717-705
    @SerializedName("cell")
    var cell: String = "", // 062-1886-576
    @SerializedName("id")
    var id: Id = Id(),
    @SerializedName("picture")
    var picture: Picture = Picture(),
    @SerializedName("nat")
    var nat: String = "" // RS
) : Serializable

data class Info(
    @SerializedName("seed")
    var seed: String = "", // 1dc922462f4ba0a0
    @SerializedName("results")
    var results: Int = 0, // 10
    @SerializedName("page")
    var page: Int = 0, // 1
    @SerializedName("version")
    var version: String = "" // 1.4
): Serializable

data class Name(
    @SerializedName("title")
    var title: String = "", // Mr
    @SerializedName("first")
    var first: String = "", // Zlatko
    @SerializedName("last")
    var last: String = "" // Rodić
): Serializable

data class Location(
    @SerializedName("street")
    var street: Street = Street(),
    @SerializedName("city")
    var city: String = "", // Sjenica
    @SerializedName("state")
    var state: String = "", // North Banat
    @SerializedName("country")
    var country: String = "", // Serbia
    @SerializedName("postcode")
    var postcode: String = "", // 95668
    @SerializedName("coordinates")
    var coordinates: Coordinates = Coordinates(),
    @SerializedName("timezone")
    var timezone: Timezone = Timezone()
): Serializable

data class Login(
    @SerializedName("uuid")
    var uuid: String = "", // fa09eb6f-1a18-461e-8457-0f007bac3cb0
    @SerializedName("username")
    var username: String = "", // greenkoala137
    @SerializedName("password")
    var password: String = "", // digital
    @SerializedName("salt")
    var salt: String = "", // fQgFzf6q
    @SerializedName("md5")
    var md5: String = "", // 650d0f061935fc9cdf610a54c6ab929f
    @SerializedName("sha1")
    var sha1: String = "", // 4dd573b384b9c5aa9a50af30110991d1b97f710a
    @SerializedName("sha256")
    var sha256: String = "" // e99581ef72eb032ca961f4560d391d08b90cfe94e222b27c467589c08f47537d
): Serializable

data class Dob(
    @SerializedName("date")
    var date: String = "", // 2000-12-09T01:17:27.905Z
    @SerializedName("age")
    var age: Int = 0 // 22
): Serializable

data class Registered(
    @SerializedName("date")
    var date: String = "", // 2002-09-12T00:04:00.984Z
    @SerializedName("age")
    var age: Int = 0 // 20
): Serializable

data class Id(
    @SerializedName("name")
    var name: String = "", // SID
    @SerializedName("value")
    var value: String = "" // 601765903
): Serializable

data class Picture(
    @SerializedName("large")
    var large: String = "", // https://randomuser.me/api/portraits/men/2.jpg
    @SerializedName("medium")
    var medium: String = "", // https://randomuser.me/api/portraits/med/men/2.jpg
    @SerializedName("thumbnail")
    var thumbnail: String = "" // https://randomuser.me/api/portraits/thumb/men/2.jpg
): Serializable

data class Street(
    @SerializedName("number")
    var number: Int = 0, // 5890
    @SerializedName("name")
    var name: String = "" // Vinogradi
): Serializable

data class Coordinates(
    @SerializedName("latitude")
    var latitude: String = "", // 57.7848
    @SerializedName("longitude")
    var longitude: String = "" // -27.9901
): Serializable

data class Timezone(
    @SerializedName("offset")
    var offset: String = "", // -11:00
    @SerializedName("description")
    var description: String = "" // Midway Island, Samoa
): Serializable