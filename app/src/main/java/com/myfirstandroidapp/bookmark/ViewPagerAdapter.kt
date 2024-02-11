package com.myfirstandroidapp.bookmark

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
class ViewPagerAdapter (fragment : FragmentActivity) : FragmentStateAdapter(fragment){


        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> RecommendListFragment()
                else -> BookmarkFragment()

            }
        }
    }
