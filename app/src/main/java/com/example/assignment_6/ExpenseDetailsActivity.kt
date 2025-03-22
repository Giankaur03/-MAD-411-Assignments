package com.example.assignment_6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment_6.databinding.ExpenseDetailsBinding

class ExpenseDetailsActivity: AppCompatActivity() {

    private lateinit var binding: ExpenseDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.expence_item)


        binding = ExpenseDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val expense = intent.getStringExtra("Expense_Name")
        val amount = intent.getStringExtra("Expense_Amount")

        binding.DisplayExpence.text = "Expence Name: $expense"
        binding.displayAmount.text = "Expense Amount: $amount"


    }

}