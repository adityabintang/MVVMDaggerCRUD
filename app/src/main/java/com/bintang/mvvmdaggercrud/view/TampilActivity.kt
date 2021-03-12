package com.bintang.mvvmdaggercrud.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bintang.mvvmdaggercrud.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_tampil.*
import javax.inject.Inject

class TampilActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tampil)


        addFloat.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}