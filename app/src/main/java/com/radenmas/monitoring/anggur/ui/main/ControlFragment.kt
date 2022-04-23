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
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.radenmas.monitoring.anggur.databinding.FragmentControlBinding

/**
 * Created by RadenMas on 17/03/2022.
 */
class ControlFragment : Fragment() {

    private lateinit var b: FragmentControlBinding

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
            val stateLamp = Firebase.database.getReference("lamp")
            if (isChecked) {
                stateLamp.setValue(1)
            } else {
                stateLamp.setValue(0)
            }
        }
    }

    private fun initView() {

    }
}