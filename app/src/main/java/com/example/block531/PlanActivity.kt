package com.example.block531


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.block531.fragments.BottomMenu

class PlanActivity : AppCompatActivity() {

    private lateinit var bottomMenu: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan)
        setSupportActionBar(findViewById(R.id.toolbar))

        // Enable night theme
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        // Embed fragments
        supportFragmentManager.let {fm ->
            // Create each fragment, reference it, and add it to the transaction
            fm.beginTransaction().run {
                bottomMenu = BottomMenu.newInstance()
                add(R.id.frame_bottom_menu, bottomMenu)

                // Run the transaction
                commit()
            }
        }
    }
}