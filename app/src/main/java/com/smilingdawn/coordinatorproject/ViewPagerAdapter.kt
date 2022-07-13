package com.smilingdawn.coordinatorproject

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.smilingdawn.coordinatorproject.FirstFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    val firstFragment = FirstFragment()
    val secondFragment = SecondFragment()

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        when(position) {
            0 -> {
                return firstFragment
            }
            1 -> {
                return secondFragment
            }
        }

        return firstFragment
    }
}