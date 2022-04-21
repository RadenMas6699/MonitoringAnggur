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
import com.radenmas.monitoring.anggur.databinding.FragmentInfoBinding

/**
 * Created by RadenMas on 17/03/2022.
 */
class InfoFragment : Fragment() {

    private lateinit var b: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b = FragmentInfoBinding.inflate(layoutInflater, container, false)
        val v = b.root

        initView()
        onClick()

        return v
    }

    private fun onClick() {
        b.tvDay.setOnClickListener { }
        b.tvWeek.setOnClickListener { }
        b.tvMonth.setOnClickListener { }
    }

    private fun initView() {

    }
}