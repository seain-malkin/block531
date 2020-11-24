package com.example.block531


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate

class PlanActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan)

        // Enable night theme
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        // Embed fragments
        supportFragmentManager.let {fm ->
            // Create each fragment, reference it, and add it to the transaction
            fm.beginTransaction().run {


                // Run the transaction
                commit()
            }
        }
    }
}