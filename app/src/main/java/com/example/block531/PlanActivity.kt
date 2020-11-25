package com.example.block531


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.block531.fragments.BottomMenu
import com.example.block531.fragments.Program

/**
 * Activity that displays the training program and report fragments
 * @author seainmalkin@gmail.com
 */
class PlanActivity :
        BottomMenu.BottomMenuListener,
        AppCompatActivity() {

    /** @property[bottomMenu] Reference to [BottomMenu] fragment */
    private lateinit var bottomMenu: Fragment

    private lateinit var program: Fragment

    /**
     * @see[AppCompatActivity.onCreate]
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Load the activity view
        setContentView(R.layout.activity_plan)

        // Attach the tool bar
        setSupportActionBar(findViewById(R.id.toolbar))

        // Enable night theme
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        // Attach fragments
        supportFragmentManager.let {fm ->
            // Create each fragment, reference it, and add it to the transaction
            fm.beginTransaction().run {
                // Bottom Navigation Menu
                bottomMenu = BottomMenu.newInstance()
                replace(R.id.frame_bottom_menu, bottomMenu)

                // Program fragment
                program = Program.newInstance()
                replace(R.id.frame_content, program)

                // Apply changes
                commit()
            }
        }
    }

    /**
     * @see[BottomMenu.BottomMenuListener.onMenuChange]
     */
    override fun onMenuChange(item: Int) {
        Log.i("PlanActivity", "$item")
    }
}