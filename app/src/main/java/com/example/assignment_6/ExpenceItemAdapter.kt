package com.example.assignment_6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExpenceItemAdapter(private val expenses: MutableList<Expense>,
    private val onDeleteClick: (Int)-> Unit):
RecyclerView.Adapter<ExpenceItemAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val expence: TextView
        val amount: TextView
        val delete: Button

        init {
            expence = view.findViewById(R.id.DisplayExpence)
            amount = view.findViewById(R.id.displayAmount)
            delete = view.findViewById(R.id.deleteitem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.expense_item, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val expense = expenses[position]
        holder.expence.text = expense.name
        holder.amount.text = "CAD${expense.amount}"
        holder.delete.setOnClickListener {
            onDeleteClick(position)
        }

    }

    override fun getItemCount(): Int = expenses.size


}

