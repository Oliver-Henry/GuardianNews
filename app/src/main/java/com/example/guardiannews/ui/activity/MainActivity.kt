package com.example.guardiannews.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.bumptech.glide.RequestManager
import com.example.guardiannews.R
import com.example.guardiannews.ui.base.BaseActivity
import dagger.android.DaggerActivity
import javax.inject.Inject

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
    }


}