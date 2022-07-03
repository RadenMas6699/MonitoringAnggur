/*
 * Created by RadenMas on 22/4/2022.
 * Copyright (c) 2022.
 */

package com.radenmas.monitoring.anggur.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.radenmas.monitoring.anggur.databinding.FragmentHomeBinding
import java.text.SimpleDateFormat

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

        FirebaseDatabase.getInstance().getReference("monitoring").limitToLast(1)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (snapshot in snapshot.children) {
                        val temp = snapshot.child("temp").value.toString()
                        val hum = snapshot.child("hum").value.toString()
                        val soil = snapshot.child("soil").value.toString()
                        val cahaya = snapshot.child("cahaya").value.toString()
                        val water = snapshot.child("water").value.toString()

                        b.tvTemp.text = "$temp \u2103"
                        b.tvHum.text = "$hum %"
                        b.tvSoil.text = "$soil %"
                        b.tvIntensity.text = cahaya
                        b.tvWater.text = "$water m3"
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
    }
}