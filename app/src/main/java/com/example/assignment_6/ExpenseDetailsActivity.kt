package com.example.assignment_6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ExpenseDetailsActivity: AppCompatActivity() {

    private lateinit var binding: ExpenseDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.expence_item)


        binding = ExpenseDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val expense = intent.getStringExtra("Expense_Name")
        val amount = intent.getStringExtra("Expense_Amount")

        binding.textViewExpenceName.text = "Expence Name: $expense"
        binding.textViewExpenseAmount.text = "Expense Amount: $amount"


    }

}