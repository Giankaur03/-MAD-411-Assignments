package com.example.assignment_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class Footer(private val totalCost:Double): Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View?{
        val view = inflater.inflate(R.layout.footer, container, false)


        val footer = view.findViewById<TextView>(R.id.footer)
        footer.text = "Total Expense: $ $totalCost"

        return view
    }
}