package com.example.islamiappproject.islamiapp.a.islamiapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.islamiappproject.databinding.ItemSuraVerseBinding

class SuraVersesAdapter(var list:List<String>?) :Adapter<SuraVersesAdapter.viewHolder>(){
var onHadethClickListener:OnHadethClickListener?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val bind=ItemSuraVerseBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return viewHolder(bind)
    }

    override fun getItemCount(): Int {
        return list?.size?:0
    }


    override fun onBindViewHolder(holder: viewHolder, position: Int) {
            var item=list?.get(position)?:return
        holder.binding.root.setOnClickListener({
           onHadethClickListener?.OnHadethClick(position)
        })
             holder.bind(item)


    }

     fun updateData(textFileContent:List<String>){
        this.list=textFileContent
        notifyDataSetChanged()

    }
    class viewHolder(var binding:ItemSuraVerseBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item:String){
            binding.suraverse.text=item
        }
    }
    interface OnHadethClickListener{
        fun OnHadethClick(position: Int){}
    }
}