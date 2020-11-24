package com.example.block531

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.appcompat.app.AppCompatDelegate
import com.example.block531.fragments.TicksFragment
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.util.Log
import java.net.URI

private const val PICK_CONTACT_REQUEST = 1

class PlanActivity : AppCompatActivity() {

    /**  Reference to the [TicksFragment] object */
    private lateinit var ticksFragment: TicksFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan)

        // Enable night theme
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        // Embed fragments
        supportFragmentManager.let {fm ->
            // Create each fragment, reference it, and add it to the transaction
            fm.beginTransaction().run {
                // Ticks Fragment setup
                ticksFragment = TicksFragment.newInstance(1, 1, 1)
                add(R.id.fragmentTicks, ticksFragment)

                // Run the transaction
                commit()
            }
        }
    }
}