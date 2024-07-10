package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamiappproject.databinding.ItemSuraNameBinding
import com.example.islamiappproject.islamiapp.a.islamiapp.SuraNameData

class SuraNameIndexAdapter(val itemlist:List<SuraNameData>?): RecyclerView.Adapter<SuraNameIndexAdapter.viewHolder>() {
      var onSuraNameClickListener:OnSuraNameClickListener?=null
       override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
          val binding=ItemSuraNameBinding.inflate(LayoutInflater.from(parent.context),parent,false)
           return viewHolder(binding)
       }

       override fun getItemCount(): Int {
           return itemlist?.size?:0
       }

       override fun onBindViewHolder(holder: viewHolder, position: Int) {
          val item=itemlist?.get(position)?:return

           holder.binding.root.setOnClickListener {
               onSuraNameClickListener?.onSuraNameClick(item.name, item.index)
           }

           holder.bind(item)

       }


       class viewHolder(val binding: ItemSuraNameBinding):ViewHolder(binding.root){
           fun bind(item:SuraNameData){
               binding.quranName.text=item.name
               binding.quranIndex.text="${item.index}"
           }
       }
    interface OnSuraNameClickListener{
        fun onSuraNameClick( suraName:String, index:Int){}
    }

   }