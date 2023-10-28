package com.example.novelr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class about_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_page)

        val actionbar = supportActionBar
        actionbar!!.title = "About Page"
        actionbar.setDisplayHomeAsUpEnabled(true)
    }
}