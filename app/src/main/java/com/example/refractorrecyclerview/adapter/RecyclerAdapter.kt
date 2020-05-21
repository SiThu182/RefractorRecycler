package com.example.refractorrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.refractorrecyclerview.R
import kotlinx.android.synthetic.main.item_recycler.view.*


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.TextItemViewHolder>() {

    var data = ArrayList<InputText>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {

//        val layoutInflater = LayoutInflater.from(parent.context)
//        val view = layoutInflater
//            .inflate(R.layout.item_recycler,
//                parent, false)
//
//        return TextItemViewHolder(view)

        return TextItemViewHolder.from(parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    class TextItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(item: InputText){
            itemView.itemInput.text = item.textInput
        }

        companion object {
            fun from(parent: ViewGroup): TextItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.item_recycler, parent, false)

                return TextItemViewHolder(view)
            }
        }
    }
}