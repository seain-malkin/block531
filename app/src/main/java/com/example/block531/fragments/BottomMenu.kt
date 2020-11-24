package com.example.block531.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.block531.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.RuntimeException

const val ITEM_PROGRAM = 0
const val ITEM_REPORTS = 1

/**
 * A simple [Fragment] subclass.
 * Use the [BottomMenu.newInstance] factory method to
 * create an instance of this fragment.
 */
class BottomMenu : Fragment() {

    /** @property[listener] A reference to calling activity */
    private lateinit var listener: BottomMenuListener

    /**
     * Interface for listener methods to be implemented by calling activity
     */
    interface BottomMenuListener {
        /**
         * Triggered when the user changes menu items
         * @param[item] The item number clicked
         */
        fun onMenuChange(item: Int)
    }

    /**
     * Enforces calling activity implements the listener interface
     * @see[Fragment.onAttach]
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)

        // Reference context as listener if implements interface. Or throw exception
        if (context is BottomMenuListener) {
            listener = context
        } else {
            throw RuntimeException("${context} must implement BottomMenuListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bottom_menu, container, false)

        // Find the bottom navigation and attach events
        view.findViewById<BottomNavigationView>(R.id.bottom_nav).run {

            // Inform listener of menu item change
            setOnNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.program -> {
                        listener.onMenuChange(ITEM_PROGRAM)
                        true
                    }
                    R.id.reports -> {
                        listener.onMenuChange(ITEM_REPORTS)
                        true
                    }
                    else -> false
                }
            }

            // Do nothing if active menu item is re-selected
            setOnNavigationItemReselectedListener { false }
        }

        return view
    }

    companion object {
        /**
         * Returns a new instance of this fragment
         *
         * @return A new instance of fragment BottomMenu.
         */
        @JvmStatic
        fun newInstance() = BottomMenu()
    }
}