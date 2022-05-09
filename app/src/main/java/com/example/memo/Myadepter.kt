package com.example.memo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_memo.view.*

class Myadepter  (val context: Context,
                var list : List<MemoEntity>,
                var onDeleteListener: OnDeleteListener) : RecyclerView.Adapter<Myadepter.MyviewHoder >(){




    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHoder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_memo,parent,false)

        return MyviewHoder(itemView)
    }

    override fun onBindViewHolder(holder: MyviewHoder, position: Int) {
        val memo = list[position]

        holder.memo.text = memo.memo
        holder.root.setOnLongClickListener(object : View.OnLongClickListener{
            override fun onLongClick(p0: View?): Boolean {
                    onDeleteListener.onDeleteListener(memo)
                return true
            }

        })
    }

    inner class MyviewHoder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val memo = itemView.textview_memo
        val root = itemView.root

    }


}
