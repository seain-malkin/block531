package com.example.block531.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.block531.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_BLOCK = "block"
private const val ARG_WEEK = "week"
private const val ARG_DAY = "day"

/**
 * A simple [Fragment] subclass.
 * Use the [TicksFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TicksFragment : Fragment() {
    private var block: Int? = null
    private var week: Int? = null
    private var day: Int? = null

    private lateinit var blockTick: TextView
    private lateinit var weekTick: TextView
    private lateinit var dayTick: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            block = it.getInt(ARG_BLOCK)
            week = it.getInt(ARG_WEEK)
            day = it.getInt(ARG_DAY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_ticks, container, false)

        // Find elements in view
        blockTick = v.findViewById(R.id.tickBlock)
        weekTick = v.findViewById(R.id.tickWeek)
        dayTick = v.findViewById(R.id.tickDay)

        // Set element values
        blockTick.text = getString(R.string.tick_block, block)
        weekTick.text = getString(R.string.tick_week, week)
        dayTick.text = getString(R.string.tick_day, day)

        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TicksFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(block: Int, week: Int, day: Int) =
            TicksFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_BLOCK, block)
                    putInt(ARG_WEEK, week)
                    putInt(ARG_DAY, day)
                }
            }
    }
}