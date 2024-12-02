package com.app.bottomnavigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.app.bottomnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        binding?.run {
            bnvMain.setOnItemSelectedListener {
                when(it.itemId){
                    R.id.main_profile -> {
                        navigateTo(ProfileFragment())
                        true
                    }
                    R.id.main_home -> {
                        navigateTo(HomeFragment())
                        true
                    }
                    R.id.main_settings -> {
                        navigateTo(SettingsFragment())
                        true
                    }
                    else -> false
                }
            }
            bnvMain.selectedItemId = R.id.main_home
        }
    }

    override fun onBackPressed() {
        binding?.run{
            if(bnvMain.selectedItemId != R.id.main_home){
                bnvMain.selectedItemId = R.id.main_home
            }else{
                super.onBackPressed()
            }
        }
    }
    private fun navigateTo(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment, fragment.javaClass.name)
            .commit()
    }
}