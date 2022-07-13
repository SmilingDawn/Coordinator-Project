package com.smilingdawn.coordinatorproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.constraintlayout.utils.widget.MotionButton
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    var viewpager: ViewPager2? = null
    var adapter = ViewPagerAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager = findViewById(R.id.viewpager)
        viewpager?.adapter = adapter

        val tabLayout = findViewById<TabLayout>(R.id.tablayout)
        viewpager?.let {
            TabLayoutMediator(tabLayout, it) { tab, position ->
                tab.text = "LABEL ${(position + 1)}"
            }.attach()
        }

        findViewById<MotionButton>(R.id.button).setOnClickListener {
            Toast.makeText(this, "Button", Toast.LENGTH_SHORT).show()
        }
    }
}