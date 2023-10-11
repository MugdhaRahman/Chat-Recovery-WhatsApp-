package com.androvine.chatrecovery

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.androvine.chatrecovery.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {

    private val binding: ActivityIntroBinding by lazy {
        ActivityIntroBinding.inflate(layoutInflater)
    }

    private var clickCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupForwardButton()


        binding.startBtn.setOnClickListener {
            startActivity(Intent(this, PermissionActivity::class.java))
            IntroUtils(this).setFirstTimeLaunch(false)
        }

    }


    private fun setupForwardButton() {

        binding.btnForward.setOnClickListener {

            clickCount++

            when (clickCount) {
                1 -> showSecondScreen()
                2 -> showThirdScreen()
                else -> {
                    clickCount = 0
                    showFirstScreen()
                }
            }

        }


    }

    private fun showFirstScreen() {

        binding.topLayout.setBackgroundResource(R.drawable.intro_bg_1)
        binding.introDot.setImageResource(R.drawable.intro_dot_1)
        binding.introImg.setImageResource(R.drawable.intro_img_1)

        binding.introTitle.text = getString(R.string.intro_title_1)
        binding.introDesc.text = getString(R.string.intro_desc_1)

    }

    private fun showSecondScreen() {

        binding.topLayout.setBackgroundResource(R.drawable.intro_bg_2)
        binding.introDot.setImageResource(R.drawable.intro_dot_2)
        binding.introImg.setImageResource(R.drawable.intro_img_1)

        binding.introTitle.text = getString(R.string.intro_title_2)
        binding.introDesc.text = getString(R.string.intro_desc_2)


    }

    private fun showThirdScreen() {

        binding.topLayout.setBackgroundResource(R.drawable.intro_bg_3)
        binding.introDot.setImageResource(R.drawable.intro_dot_3)
        binding.introImg.setImageResource(R.drawable.intro_img_1)

        binding.introTitle.text = getString(R.string.intro_title_2)
        binding.introDesc.text = getString(R.string.intro_desc_2)

        binding.btnForward.visibility = View.GONE
        binding.startBtn.visibility = View.VISIBLE

    }



}