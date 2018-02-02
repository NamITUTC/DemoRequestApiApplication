package com.ominext.namnt.demorequestapiapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_maps.*
import okhttp3.Callback
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, View.OnClickListener {


    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        btn_call_map.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        ApiClient.getInstance()!!.create(ApiService::class.java).getDataMap().enqueue(object : retrofit2.Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                Log.d("onFailure", t!!.message)
            }

            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                if (response!!.isSuccessful){
                    Log.d("onResponse", response.body().string())
                var jsonObjectRoot = JSONObject(response.body().string())
                val jsonArrayResults = jsonObjectRoot.getJSONArray("results")

                for (j in 0 until jsonArrayResults.length()) {

                    val jsonObjectResult = jsonArrayResults.getJSONObject(j)

                    val name = jsonObjectResult.getString("name")
                    val address = jsonObjectResult.getString("vicinity")

                    val jsonObjectGeometry = jsonObjectResult.getJSONObject("geometry")
                    val jsonObjectLocation = jsonObjectGeometry.getJSONObject("location")

                    val lat = jsonObjectLocation.getDouble("lat")
                    val lng = jsonObjectLocation.getDouble("lng")
                    Log.d("onResponse", "name:"+name+"address:"+address+"lat:"+lat+"lng:"+lng+"")}
                }

                //
            }
        })
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}
