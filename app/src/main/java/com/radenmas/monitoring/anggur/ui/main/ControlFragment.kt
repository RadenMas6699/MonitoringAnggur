/*
 * Created by RadenMas on 22/4/2022.
 * Copyright (c) 2022.
 */

package com.radenmas.monitoring.anggur.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.radenmas.monitoring.anggur.databinding.FragmentControlBinding

/**
 * Created by RadenMas on 17/03/2022.
 */
class ControlFragment : Fragment() {

    private lateinit var b: FragmentControlBinding

    private var stateLamp = Firebase.database.getReference("control").child("lamp")
    private var stateMistMaker = Firebase.database.getReference("control").child("mist")
    private var stateWaterPump = Firebase.database.getReference("control").child("pump")
    private var statePupuk = Firebase.database.getReference("control").child("pupuk")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b = FragmentControlBinding.inflate(layoutInflater, container, false)
        val v = b.root

        initView()
        onClick()

        return v
    }

    private fun onClick() {
        b.switchLamp.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                stateLamp.setValue(1)
            } else {
                stateLamp.setValue(0)
            }
        }
        b.switchMistMaker.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                stateMistMaker.setValue(1)
            } else {
                stateMistMaker.setValue(0)
            }
        }
        b.switchWaterPump.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                stateWaterPump.setValue(1)
            } else {
                stateWaterPump.setValue(0)
            }
        }
        b.switchFertilizer.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                statePupuk.setValue(1)
            } else {
                statePupuk.setValue(0)
            }
        }
    }

    private fun initView() {

    }
}