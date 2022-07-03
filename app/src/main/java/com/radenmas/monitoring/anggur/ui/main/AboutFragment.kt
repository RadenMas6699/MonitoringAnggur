/*
 * Created by RadenMas on 22/5/2022.
 * Copyright (c) 2022.
 */

package com.radenmas.monitoring.anggur.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.radenmas.monitoring.anggur.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {
    private lateinit var b: FragmentAboutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b = FragmentAboutBinding.inflate(layoutInflater, container, false)
        val v = b.root

        return v
    }


}