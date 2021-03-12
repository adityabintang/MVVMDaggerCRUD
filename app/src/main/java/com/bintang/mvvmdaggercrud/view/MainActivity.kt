package com.bintang.mvvmdaggercrud.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bintang.mvvmdaggercrud.R
import com.bintang.mvvmdaggercrud.dagger.viewmodel.ViewModelProvideFactory
import com.bintang.mvvmdaggercrud.model.ResponseTambah
import com.bintang.mvvmdaggercrud.viewmodel.ViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvideFactory
    private lateinit var viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, viewModelFactory).get(ViewModel::class.java)
        observer()

        btnTambah.setOnClickListener {
            var nama = Nama.text.toString()
            var alamat = Alamat.text.toString()
            var agama = Agama.text.toString()
            var jenisKelamin = Jenis_kelamin.text.toString()
            var hobi = Hobi.text.toString()
            viewModel.tambahData(nama, alamat, agama, jenisKelamin, hobi)
        }
    }

    private fun observer() {
        viewModel.isSuccess().observe(this, Observer { ResponseSuccess(it) })
        viewModel.isError().observe(this, Observer { ResponseError(it) })
    }

    private fun ResponseError(it: Throwable?) {
        Toast.makeText(this, it?.localizedMessage, Toast.LENGTH_SHORT).show()
    }

    private fun ResponseSuccess(it: ResponseTambah?) {
        if (it?.status == 200){
            val intent = Intent(applicationContext, TampilActivity::class.java)
            startActivity(intent)
        }
    }
}