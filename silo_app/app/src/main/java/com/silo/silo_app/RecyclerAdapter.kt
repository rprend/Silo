package com.silo.silo_app

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView


const val TITLE_INTENT = "title_message"

class CardData (private val title: String, private val description: String, private val image: Int)

class RecyclerAdapter (private val dataSet: List<String>):

    RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    class RecyclerViewHolder(val view: MaterialCardView): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_card, parent, false) as MaterialCardView

        return RecyclerViewHolder(cardView)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val text: TextView = holder.view.findViewById(R.id.title)
        val score: TextView = holder.view.findViewById(R.id.eco_score)
        val date: TextView = holder.view.findViewById(R.id.date)
        text.text = dataSet[position];
        if (position == 1) {
            score.text = "720 "
            date.text = "May 2019 - August 2019"
        }
        if (position == 2) {
            date.text = "September 2019 - October 2019"
        }
        if (position == 0) {
            score.text = "830 "
            date.text = "April 2019 - May 2019"
        }
//        val image: ImageView = holder.view.findViewById(R.id.image_bigcard)
//        val title = dataSet[position]
//        text.text = title

        holder.view.setOnClickListener {
//            val context = it.context
//            val intent = Intent(context, InfoActivity::class.java)
//            intent.putExtra(TITLE_INTENT, title)
//            context.startActivity(intent)
        }
    }
}