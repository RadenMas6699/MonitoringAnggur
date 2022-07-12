/*
 * Created by RadenMas on 22/4/2022.
 * Copyright (c) 2022.
 */

package com.radenmas.monitoring.anggur.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.radenmas.monitoring.anggur.R
import com.radenmas.monitoring.anggur.databinding.FragmentHomeBinding

/**
 * Created by RadenMas on 17/03/2022.
 */
class HomeFragment : Fragment() {

    private lateinit var b: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b = FragmentHomeBinding.inflate(layoutInflater, container, false)
        val v = b.root

        initView()

        return v
    }

    private fun initView() {

        FirebaseDatabase.getInstance().getReference("realtime")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val temp = snapshot.child("temp").value.toString().toFloat().toInt()
                    val hum = snapshot.child("hum").value.toString().toInt()
                    val soil = snapshot.child("soil").value.toString().toInt()
                    val cahaya = snapshot.child("cahaya").value.toString().toInt()
                    val water = snapshot.child("water").value.toString().toInt()

                    setBackgroundText(b.tvTemp, temp, 25, 30)
                    setBackgroundText(b.tvHum, hum, 70, 80)
                    setBackgroundText(b.tvSoil, soil, 50, 80)
                    setBackgroundText(b.tvIntensity, cahaya, 50, 80)
                    setBackgroundText(b.tvWater, water, 25, 30)

                    b.tvTemp.text = "$temp \u2103"
                    b.tvHum.text = "$hum %"
                    b.tvSoil.text = "$soil"
                    b.tvIntensity.text = "$cahaya %"
                    b.tvWater.text = "$water"
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
    }

    fun setBackgroundText(textView: TextView, value: Int, low: Int, high: Int) {
        when (value) {
            in low..high -> {
                textView.setBackgroundResource(R.drawable.bg_value_green)
            }
            else -> {
                textView.setBackgroundResource(R.drawable.bg_value_red)
            }
        }
    }
}