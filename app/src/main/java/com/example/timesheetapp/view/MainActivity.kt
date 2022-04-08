package com.example.timesheetapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.timesheetapp.R
import com.example.timesheetapp.view.adapters.ViewPager2Adapter
import com.example.timesheetapp.view.screens.*
import com.example.timesheetapp.viewmodel.MainActivityViewModel
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager2)
        val monthText = findViewById<TextView>(R.id.monthText)
        val dotsIndicator = findViewById<WormDotsIndicator>(R.id.worm_dots_indicator)


        val fragments = arrayListOf(
            JanuaryFragment(),
            FebruaryFragment(),
            MarchFragment(),
            AprilFragment(),
            MayFragment(),
            JuneFragment(),
            JulyFragment()
        )

        val adapter = ViewPager2Adapter(fragments, this)


        viewPager2.adapter = adapter

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        viewModel.liveData.observe(this) {
            findViewById<TextView>(R.id.textView).text = it
        }

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                monthText.text = when (position) {
                    0 -> "Январь"
                    1 -> "Февраль"
                    2 -> "Март"
                    3 -> "Апрель"
                    4 -> "Май"
                    5 -> "Июнь"
                    else -> "Июль"
                }
            }
        })

        dotsIndicator.setViewPager2(viewPager2)

    }
}