package com.ashupandey.view.click.lisner.various.views.and.learnigapicall

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("users")
    suspend fun getData(
            @Query("page") page : Int = 1
    ):Response<DataItem>?
}
