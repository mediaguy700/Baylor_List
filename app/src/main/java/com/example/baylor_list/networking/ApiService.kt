package com.example.baylor_list.networking

import com.example.baylor_list.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService{


@GET("/users")
fun fetchAllUsers(): Call<List<User>>

}