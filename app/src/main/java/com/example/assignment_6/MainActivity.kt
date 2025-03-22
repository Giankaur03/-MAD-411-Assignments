package com.example.assignment_6

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
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

    private lateinit var buttonFinTips: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.beginTransaction().add(R.id.headerContainer, Header()).commit()


        Log.d("Lifecycle", "onCreate called")

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

        buttonFinTips.setOnClickListener{
            openFinTips()
        }
    }

    private fun addExpence() {
        val name = editExpencename.text.toString().trim()
        val amount = editAmount.text.toString().trim()

        if (name.isNotEmpty() && amount.isNotEmpty()) {
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

        updateFooter()
    }

    private fun showExpDetails(expense: Expense){
        val intel = Intent(this, ExpenseDetailsActivity::class.java).apply{
            putExtra("Expense_Name", expense.name)
            putExtra("Expense_Amount", expense.amount)
        }

        startActivity(intent)
    }

    private fun updateFooter(){
        val totalCost = expenseList.sumOf { it.amount.toDouble()?: 0.0 }
        supportFragmentManager.beginTransaction().replace(R.id.footer, Footer(totalCost)).commit()
    }


    private fun openFinTips(){
        val intent = Intent(Intent.ACTION_VIEW).apply{
            data = Uri.parse("https://www.bark.com/en/ca/in/financial-advisors/?campaign=bing-376618450-1266638062341510-financial-advisors-c&popup=true&trk_ad_id=79165042235869&trk_kw_id=kwd-79165257151257:loc-4062&trk_msloc_phs=124876&trk_msloc_int=&trk_src=b&trk_msclid=67c57e4ad6dd1aa0f782199727dd6f42&msclkid=67c57e4ad6dd1aa0f782199727dd6f42&utm_source=bing&utm_medium=cpc&utm_campaign=Financial%20Advice%20-%20National&utm_term=financial%20service%20advisor&utm_content=financial-advisors")
        }
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "onDestroy")
    }

}



