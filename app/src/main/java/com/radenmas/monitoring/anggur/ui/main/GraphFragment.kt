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
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.radenmas.monitoring.anggur.R
import com.radenmas.monitoring.anggur.databinding.FragmentGraphBinding

/**
 * Created by RadenMas on 17/03/2022.
 */
class GraphFragment : Fragment() {


    private lateinit var b: FragmentGraphBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b = FragmentGraphBinding.inflate(layoutInflater, container, false)
        val v = b.root

        initView()
        onClick()

        return v
    }

    private fun onClick() {
        b.tvTemp.setOnClickListener {
            clicked(b.tvTemp, b.tvHum, b.tvSoil, b.tvLight, b.tvWater)
            getTemp()
        }
        b.tvHum.setOnClickListener {
            clicked(b.tvHum, b.tvTemp, b.tvSoil, b.tvLight, b.tvWater)
            getHum()
        }
        b.tvSoil.setOnClickListener {
            clicked(b.tvSoil, b.tvHum, b.tvTemp, b.tvLight, b.tvWater)
            getSoil()
        }
        b.tvLight.setOnClickListener {
            clicked(b.tvLight, b.tvHum, b.tvSoil, b.tvTemp, b.tvWater)
            getLight()
        }
        b.tvWater.setOnClickListener {
            clicked(b.tvWater, b.tvHum, b.tvSoil, b.tvLight, b.tvTemp)
            getWater()
        }
    }

    private fun initView() {
        clicked(b.tvTemp, b.tvHum, b.tvSoil, b.tvLight, b.tvWater)
        getTemp()
    }

    private fun getTemp() {
        FirebaseDatabase.getInstance().reference.child("monitoring").limitToLast(1440)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        val dataTemp = ArrayList<Entry>()
                        for (snapshot in snapshot.children) {
                            val temp = snapshot.child("temp").value.toString().toFloat()
                            val time = snapshot.child("time").value.toString().toFloat()
                            dataTemp.add(Entry(time, temp))
                        }
                        chart(b.chart, dataTemp, 0, 50)
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
    }

    private fun getHum() {
        FirebaseDatabase.getInstance().reference.child("monitoring").limitToLast(1440)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        val dataHum = ArrayList<Entry>()
                        for (snapshot in snapshot.children) {
                            val hum = snapshot.child("hum").value.toString().toFloat()
                            val time = snapshot.child("time").value.toString().toFloat()
                            dataHum.add(Entry(time, hum))
                        }
                        chart(b.chart, dataHum, 0, 100)
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
    }

    private fun getSoil() {
        FirebaseDatabase.getInstance().reference.child("monitoring").limitToLast(1440)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        val dataSoil = ArrayList<Entry>()
                        for (snapshot in snapshot.children) {
                            val soil = snapshot.child("soil").value.toString().toFloat()
                            val time = snapshot.child("time").value.toString().toFloat()
                            dataSoil.add(Entry(time, soil))
                        }
                        chart(b.chart, dataSoil, 0, 100)
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
    }

    private fun getLight() {
        FirebaseDatabase.getInstance().reference.child("monitoring").limitToLast(1440)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        val dataLight = ArrayList<Entry>()
                        for (snapshot in snapshot.children) {
                            val light = snapshot.child("cahaya").value.toString().toFloat()
                            val time = snapshot.child("time").value.toString().toFloat()
                            dataLight.add(Entry(time, light))
                        }
                        chart(b.chart, dataLight, 0, 100)
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
    }

    private fun getWater() {
        FirebaseDatabase.getInstance().reference.child("monitoring").limitToLast(1440)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        val dataWater = ArrayList<Entry>()
                        for (snapshot in snapshot.children) {
                            val water = snapshot.child("water").value.toString().toFloat()
                            val time = snapshot.child("time").value.toString().toFloat()
                            dataWater.add(Entry(time, water))
                        }
                        chart(b.chart, dataWater, 0, 100)
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
    }

    private fun clicked(
        tvOn: TextView,
        tvOff1: TextView,
        tvOff2: TextView,
        tvOff3: TextView,
        tvOff4: TextView
    ) {
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

        tvOff4.setTextColor(ResourcesCompat.getColor(resources, R.color.secondary_text, null))
        tvOff4.setTypeface(null, Typeface.NORMAL)
        tvOff4.setBackgroundResource(R.drawable.bg_button_unselected)
    }

    fun chart(lineChart: LineChart, values: ArrayList<Entry>, min: Int, max: Int) {
        val lineDataSet = LineDataSet(null, null)
        lineDataSet.values = values
        lineDataSet.setDrawValues(false)
        lineDataSet.cubicIntensity = 1.5f
        lineDataSet.setDrawFilled(true)
        lineDataSet.color = R.color.black
        lineDataSet.lineWidth = 2f
        val iLineDataSets = ArrayList<ILineDataSet>()
        iLineDataSets.add(lineDataSet)
        val lineData = LineData(iLineDataSets)
        val xAxis = lineChart.xAxis
        xAxis.setDrawGridLines(false)
        //        xAxis.setDrawAxisLine(false);
//        xAxis.setCenterAxisLabels(true);
//        xAxis.setTextSize(10f);
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawLabels(false)
        val yAxisL = lineChart.getAxis(YAxis.AxisDependency.LEFT)
        yAxisL.setDrawGridLines(false)
        yAxisL.setDrawLabels(true)
        yAxisL.axisMinimum = min.toFloat()
        yAxisL.axisMaximum = max.toFloat()
        lineChart.data = lineData
        lineChart.axisRight.isEnabled = false
        lineChart.legend.isEnabled = false
        lineChart.description.isEnabled = false
        lineChart.moveViewTo(lineData.entryCount.toFloat(), 50f, YAxis.AxisDependency.LEFT)
    }
}