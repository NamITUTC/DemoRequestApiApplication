package com.ominext.namnt.demorequestapiapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var intent = intent
        var link = intent.getStringExtra("link")
        Log.d("link", link)
        wv_detail.loadUrl(link)
    }
}
