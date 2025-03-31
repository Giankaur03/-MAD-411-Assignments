package com.example.assignment_6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ExpenseDetailsActivity: AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.expense_item)



        val expense = intent.getStringExtra("Expense_Name")
        val amount = intent.getStringExtra("Expense_Amount")




    }

}