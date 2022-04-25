/*
 * Created by RadenMas on 22/4/2022.
 * Copyright (c) 2022.
 */

package com.radenmas.monitoring.anggur.ui.main

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.radenmas.monitoring.anggur.R
import com.radenmas.monitoring.anggur.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        b = ActivityMainBinding.inflate(layoutInflater)
        val v = b.root
        setContentView(v)

        val dt = Date()
        when (dt.hours) {
            in 1..10 -> {
                b.tvTime.text = "Selamat Pagi"
                b.imgTime.setImageResource(R.drawable.ic_pagi)
            }
            in 11..14 -> {
                b.tvTime.text = "Selamat Siang"
                b.imgTime.setImageResource(R.drawable.ic_siang)
            }
            in 15..18 -> {
                b.tvTime.text = "Selamat Sore"
                b.imgTime.setImageResource(R.drawable.ic_sore)
            }
            in 19..24 -> {
                b.tvTime.text = "Selamat Malam"
                b.imgTime.setImageResource(R.drawable.ic_malam)
            }
        }

        val navController = findNavController(R.id.fragment)
        b.navBottom.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            b.tvTitle.text = destination.label
        }

    }
}