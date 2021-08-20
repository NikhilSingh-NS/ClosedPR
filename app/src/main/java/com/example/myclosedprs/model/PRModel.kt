package com.example.myclosedprs.model

import com.google.gson.annotations.SerializedName


data class PRModel(
    @SerializedName("title")
    val title: String,

    @SerializedName("created_at")
    val createdDate: String,

    @SerializedName("closed_at")
    val closedDate: String,

    @SerializedName("number")
    val id: Int,

    val user: User
)

data class User(
    @SerializedName("login")
    val userName: String,

    @SerializedName("avatar_url")
    val userImage: String,
    val id: Int
)