package com.example.viewpager2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager2.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroBinding
    private lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro)
        binding.btnIntroBack.setOnClickListener { finish() }
        initViewPager()
    }

    private fun initViewPager() {
        viewPager = binding.vpIntroOunce
        val pagerAdapter = IntroAdapter(this)
        viewPager.adapter = pagerAdapter
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        setBackgroundColor(getColorFromResource(R.color.ounceintro_one))
                        binding.btnIntroLeft.visibility = View.GONE
                    }
                    1 -> {
                        setBackgroundColor(getColorFromResource(R.color.ounceintro_two))
                        binding.btnIntroLeft.visibility = View.VISIBLE
                        binding.btnIntroRight.visibility = View.VISIBLE
                    }
                    else -> {
                        setBackgroundColor(getColorFromResource(R.color.ounceintro_three))
                        binding.btnIntroRight.visibility = View.GONE
                    }
                }
            }

        })
        binding.btnIntroLeft.setOnClickListener {
            binding.vpIntroOunce.setCurrentItem(binding.vpIntroOunce.currentItem - 1, true)
        }
        binding.btnIntroRight.setOnClickListener {
            binding.vpIntroOunce.setCurrentItem(binding.vpIntroOunce.currentItem + 1, true)
        }
    }

    private inner class IntroAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = NUM_PAGES


        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> IntroFragment(R.drawable.who_made_ounce_img_1)
                1 -> IntroFragment(R.drawable.who_made_ounce_img_2)
                else -> IntroFragment(R.drawable.who_made_ounce_img_3)

            }
        }

    }

    @SuppressLint("NewApi")
    private fun getColorFromResource(color: Int): Int = resources.getColor(color, null)

    private fun setBackgroundColor(color: Int) {
        binding.ounceintroBackground.setBackgroundColor(color)
        StatusBarUtil.setStatusBar(this, color)
    }

    companion object {
        private const val NUM_PAGES = 5
    }
}