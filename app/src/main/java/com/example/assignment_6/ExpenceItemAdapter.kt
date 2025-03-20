package com.example.assignment_6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ExpenceItemAdapter(private val dataSet:Array<String>):
RecyclerView.Adapter<ExpenceItemAdapter.ViewHolder>(){

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
                val expence: TextView
                val amount: TextView
                val delete: Button

                init {
                    expence= view.findViewById(R.id.DisplayExpence)
                    amount = view.findViewById(R.id.displayAmount)
                    delete= view.findViewById(R.id.deleteitem)
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.expence_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.expence.text = dataSet[position]
        holder.amount.text = dataSet[position]
        holder.delete.setOnClickListener({

        })
    }
}