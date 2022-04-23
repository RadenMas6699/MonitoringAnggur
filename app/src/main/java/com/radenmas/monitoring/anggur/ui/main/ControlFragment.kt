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

    private var stateLamp = Firebase.database.getReference("lamp")
    private var stateMistMaker = Firebase.database.getReference("mist_maker")
    private var stateWaterPump = Firebase.database.getReference("water_pump")
    private var statePupuk = Firebase.database.getReference("pupuk")

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
                stateLamp.setValue(1).addOnSuccessListener {
                    Toast.makeText(requireContext(), "Lampu On", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(requireContext(), it.message.toString(), Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Lampu Off", Toast.LENGTH_SHORT).show()
                stateLamp.setValue(0)
            }
        }
    }

    private fun initView() {

    }
}