package com.example.assignment_6

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var editExpencename: EditText
    private lateinit var editAmount: EditText
    private lateinit var button_add: Button
    private lateinit var recyclerview: RecyclerView
    private lateinit var displayExpence: ExpenceItemAdapter
    private val expenseList = mutableListOf<Expense>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initializer
        editExpencename = findViewById(R.id.editExpencename)
        editAmount = findViewById(R.id.editAmount)
        button_add = findViewById(R.id.button_add)
        recyclerview = findViewById(R.id.recycleview)

        recyclerview.layoutManager = LinearLayoutManager(this)
        displayExpence = ExpenceItemAdapter(expenseList) { position -> deleteExpence(position) }

        recyclerview.adapter = displayExpence

        button_add.setOnClickListener {
            addExpence()
        }

    }

    private fun addExpence(){
        val name = editExpencename.text.toString().trim()
        val amount = editAmount.text.toString().trim()

        if(name.isNotEmpty() && amount.isNotEmpty()){
            val expense = Expense(name, amount)
            expenseList.add(expense)
            displayExpence.notifyItemInserted(expenseList.size - 1)

            editExpencename.text.clear()
            editAmount.text.clear()
        }
    }

    private fun deleteExpence(position: Int) {
        expenseList.removeAt(position)
        displayExpence.notifyItemRemoved(position)

    }
}
