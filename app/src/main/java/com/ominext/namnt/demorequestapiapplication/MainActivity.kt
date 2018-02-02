package com.ominext.namnt.demorequestapiapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.ominext.namnt.demorequestapiapplication.adapter.HealthTipAdapter
import com.ominext.namnt.demorequestapiapplication.model.HealthTip
import com.ominext.namnt.demorequestapiapplication.model.Pathological
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener, HealthTipAdapter.IClick {
    override fun itemClick(position: Int, link: String) {
        var intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("link", link)
        startActivity(intent)

    }

    private lateinit var setvice: ApiService
    private lateinit var adapterTips: HealthTipAdapter
    private lateinit var tips: MutableList<HealthTip>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_delete.setOnClickListener(this)
        btn_get.setOnClickListener(this)
        btn_post.setOnClickListener(this)
        btn_put.setOnClickListener(this)
        btn_call.setOnClickListener(this)
        btn_map.setOnClickListener(this)

        tips = mutableListOf()
        adapterTips = HealthTipAdapter(tips as MutableList<HealthTip>, this,this)
        rc_tips.apply {
            adapter = adapterTips
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }


    }

    override fun onClick(view: View?) {

        when (view!!.id) {
            R.id.btn_get -> getData()
            R.id.btn_post -> postData()
            R.id.btn_put -> updateData()
            R.id.btn_delete -> deleteData()
            R.id.btn_call -> getHealthTips()
            R.id.btn_map->startMap()
        }
    }

    private fun startMap() {
        var intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
    }

    private fun getHealthTips() {
        ApiClient.getInstance()!!.create(ApiService::class.java).getData().enqueue(object : Callback<List<HealthTip>> {
            override fun onFailure(call: Call<List<HealthTip>>?, t: Throwable?) {
                Log.d("onFailure", t!!.message)
            }

            override fun onResponse(call: Call<List<HealthTip>>?, response: Response<List<HealthTip>>?) {
                if (response!!.isSuccessful) {
                    tips.addAll(response.body())
                    Log.d("body",response.body().toString())
                    adapterTips.notifyDataSetChanged()
                }
            }
        })
    }

    private fun deleteData() {
        var id = edt_id.text.toString().toInt()
        ApiClient.getInstance()!!.create(ApiService::class.java).deletePathological(id).enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>?, t: Throwable?) {
                Log.d("onFailure", t!!.message)
            }

            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                Log.d("onResponse", response!!.body().toString())
            }
        })
    }

    private fun updateData() {
        var id = edt_id.text.toString().toInt()
        var title = edt_title.text.toString()
        var detail = edt_detail.text.toString()
        var pathological = Pathological(id, title, detail)
        ApiClient.getInstance()!!.create(ApiService::class.java).updatePathological(id, pathological).enqueue(object : Callback<List<Pathological>> {
            override fun onResponse(call: Call<List<Pathological>>?, response: Response<List<Pathological>>?) {
                Log.d("onResponse", response!!.body().toString())
            }

            override fun onFailure(call: Call<List<Pathological>>?, t: Throwable?) {
                Log.d("onFailure", t!!.message)
            }
        })
    }

    private fun postData() {
        var id = edt_id.text.toString().toInt()
        var title = edt_title.text.toString()
        var detail = edt_detail.text.toString()
        var pathological = Pathological(id, title, detail)
        ApiClient.getInstance()!!.create(ApiService::class.java).addPathological(pathological).enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>?, t: Throwable?) {
                Log.d("onFailure", t!!.message)
            }

            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                if (response!!.isSuccessful) {
                    Log.d("onResponse", response!!.body().toString())
                }
            }
        })
    }

    private fun getData() {
        ApiClient.getInstance()!!.create(ApiService::class.java).getAllPathological().enqueue(object : Callback<List<Pathological>> {
            override fun onFailure(call: Call<List<Pathological>>?, t: Throwable?) {
                Log.d("onFailure", t!!.message)
            }

            override fun onResponse(call: Call<List<Pathological>>?, response: Response<List<Pathological>>?) {
                if (response!!.isSuccessful) {

                    Log.d("onResponse", response!!.body().toString())
                }
            }
        })
    }
}
