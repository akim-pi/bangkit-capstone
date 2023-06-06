package com.example.pollum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pollum.camera.CameraActivity
import com.example.pollum.databinding.ActivityNavigationBinding
import com.example.pollum.fragment.HomeFragment
import com.example.pollum.fragment.ProfileFragment

class NavigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navHome()

        binding.chipNavigationBar.setOnItemSelectedListener {
            when(it) {
                R.id.house -> navHome()
                R.id.cam -> navCamera()
                R.id.profile -> navProfile()
            }
        }

    }

    private fun navHome() {
        val fragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun navCamera() {
        val intent = Intent(this@NavigationActivity, CameraActivity::class.java)
        startActivity(intent)
    }

    private fun navProfile() {
        val fragment = ProfileFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .addToBackStack(null)
            .commit()
    }

}