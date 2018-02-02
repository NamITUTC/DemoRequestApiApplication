package com.ominext.namnt.demorequestapiapplication

import com.ominext.namnt.demorequestapiapplication.model.HealthTip
import com.ominext.namnt.demorequestapiapplication.model.Pathological
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by nam on 02/02/2018.
 */
interface ApiService {

    @GET("/get")
    fun getAllPathological(): Call<List<Pathological>>

    @POST("/post")
    fun addPathological(@Body pathological: Pathological): Call<String>

    @PUT("/put/{id}")
    fun updatePathological(@Path("id") id: Int, @Body pathological: Pathological): Call<List<Pathological>>

    @DELETE("/delete/{id}")
    fun deletePathological(@Path("id") id: Int): Call<String>

    @GET("/healthTips")
    fun getData(): Call<List<HealthTip>>

    @GET("/maps/api/place/radarsearch/json?location=51.503186,-0.126446&radius=5000&type=museum&key=AIzaSyAjCxDFbqC9uy11X5SKpmLzVqFXy6KKJP4")
    fun getDataMap(): Call<ResponseBody>
}