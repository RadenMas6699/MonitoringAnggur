/*
 * Created by RadenMas on 22/4/2022.
 * Copyright (c) 2022.
 */

package com.radenmas.monitoring.anggur.ui.main

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.radenmas.monitoring.anggur.R
import com.radenmas.monitoring.anggur.databinding.FragmentGrafikBinding

/**
 * Created by RadenMas on 17/03/2022.
 */
class GrafikFragment : Fragment() {


    private lateinit var b: FragmentGrafikBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b = FragmentGrafikBinding.inflate(layoutInflater, container, false)
        val v = b.root

        initView()
        onClick()


        return v


    }


    private fun onClick() {
        b.tvTemp.setOnClickListener {
            clicked(b.tvTemp, b.tvHum, b.tvSoil, b.tvLight)
        }
        b.tvHum.setOnClickListener {
            clicked(b.tvHum, b.tvTemp, b.tvSoil, b.tvLight)
        }
        b.tvSoil.setOnClickListener {
            clicked(b.tvSoil, b.tvHum, b.tvTemp, b.tvLight)
        }
        b.tvLight.setOnClickListener {
            clicked(b.tvLight, b.tvHum, b.tvSoil, b.tvTemp)
        }
    }

    private fun initView() {
        clicked(b.tvTemp, b.tvHum, b.tvSoil, b.tvLight)
    }

    private fun clicked(tvOn: TextView, tvOff1: TextView, tvOff2: TextView, tvOff3: TextView) {
        tvOn.setTextColor(ResourcesCompat.getColor(resources, R.color.primary_text, null))
        tvOn.setTypeface(null, Typeface.BOLD)
        tvOn.setBackgroundResource(R.drawable.bg_button_selected)

        tvOff1.setTextColor(ResourcesCompat.getColor(resources, R.color.secondary_text, null))
        tvOff1.setTypeface(null, Typeface.NORMAL)
        tvOff1.setBackgroundResource(R.drawable.bg_button_unselected)

        tvOff2.setTextColor(ResourcesCompat.getColor(resources, R.color.secondary_text, null))
        tvOff2.setTypeface(null, Typeface.NORMAL)
        tvOff2.setBackgroundResource(R.drawable.bg_button_unselected)

        tvOff3.setTextColor(ResourcesCompat.getColor(resources, R.color.secondary_text, null))
        tvOff3.setTypeface(null, Typeface.NORMAL)
        tvOff3.setBackgroundResource(R.drawable.bg_button_unselected)
    }


}