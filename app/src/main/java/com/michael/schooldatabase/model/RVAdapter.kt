package com.michael.schooldatabase.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.michael.schooldatabase.R
import kotlinx.android.synthetic.main.supplier.view.*

class RVAdapter(private val context: Context) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    var grades = listOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val gradeTV: TextView = view.tv_sno
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        ViewHolder(
            LayoutInflater
                .from(context)
                .inflate(R.layout.supplier, parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            gradeTV.text = grades[position]
        }
    }

    override fun getItemCount() = this.grades.size
}
