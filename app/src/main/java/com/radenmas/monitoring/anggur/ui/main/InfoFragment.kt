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
        b.tvDay.setOnClickListener {
            clicked(b.tvDay, b.tvWeek, b.tvMonth)
        }
        b.tvWeek.setOnClickListener {
            clicked(b.tvWeek, b.tvDay, b.tvMonth)
        }
        b.tvMonth.setOnClickListener {
            clicked(b.tvMonth, b.tvWeek, b.tvDay)
        }
    }

    private fun initView() {
        clicked(b.tvDay, b.tvWeek, b.tvMonth)
    }

    private fun clicked(tvOn: TextView, tvOff1: TextView, tvOff2: TextView) {
        tvOn.setTextColor(ResourcesCompat.getColor(resources, R.color.primary_text, null))
        tvOn.setTypeface(null, Typeface.BOLD)
        tvOn.setBackgroundResource(R.drawable.bg_button_selected)

        tvOff1.setTextColor(ResourcesCompat.getColor(resources, R.color.secondary_text, null))
        tvOff1.setTypeface(null, Typeface.NORMAL)
        tvOff1.setBackgroundResource(R.drawable.bg_button_unselected)

        tvOff2.setTextColor(ResourcesCompat.getColor(resources, R.color.secondary_text, null))
        tvOff2.setTypeface(null, Typeface.NORMAL)
        tvOff2.setBackgroundResource(R.drawable.bg_button_unselected)
    }
}