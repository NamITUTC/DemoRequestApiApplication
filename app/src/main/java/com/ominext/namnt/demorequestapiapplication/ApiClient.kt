package com.ominext.namnt.demorequestapiapplication

import junit.runner.Version.id
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by nam on 02/02/2018.
 */
class ApiClient {
    companion object {
        private var retrofit: Retrofit? = null
        private val BASE_URL: String = "https://maps.googleapis.com/"

        fun getInstance(): Retrofit? {
            return if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                retrofit
            } else {
                retrofit
            }
        }
    }
}