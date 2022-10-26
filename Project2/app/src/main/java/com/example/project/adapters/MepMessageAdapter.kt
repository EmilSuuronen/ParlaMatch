package com.example.project.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.project.data.Message
import com.example.project.databinding.MepMessageItemBinding


/* Emil Suuronen - 1909931
8.10.2022
*/

//Adapter for Messages RecyclerView
class MepMessageAdapter ():
    ListAdapter<Message, MepMessageAdapter.MepMessageViewHolder>(MepMessageDiffCallBack()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MepMessageViewHolder {
        return MepMessageViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MepMessageViewHolder, position: Int) {
        val message: Message = getItem(position)
        holder.bind(message)
    }

    class MepMessageViewHolder (val binding: MepMessageItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(message: Message){
            binding.message = message
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MepMessageViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MepMessageItemBinding.inflate(layoutInflater, parent, false)
                return MepMessageViewHolder(binding)
            }
        }
    }
}

class MepMessageDiffCallBack: DiffUtil.ItemCallback<Message>(){
    override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
        return oldItem == newItem
    }
}
