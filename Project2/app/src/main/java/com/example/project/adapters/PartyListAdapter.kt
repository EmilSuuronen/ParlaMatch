package com.example.project.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.project.databinding.PartyListItemBinding
/* Emil Suuronen - 1909931
3.10.2022
 */

// Adapter for party list
class PartyListAdapter (private val onClickListener: OnClickListener):
    ListAdapter<String, PartyListAdapter.PartyViewHolder>(PartyListDiffCallBack()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartyViewHolder {
        return PartyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PartyViewHolder, position: Int) {
        val party: String = getItem(position)
        holder.bind(party ,onClickListener)
        holder.binding.partyItemTitle.partyAbbreviation(party)
    }

    class PartyViewHolder (val binding: PartyListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(party: String, onClickListener: OnClickListener){
            binding.onClickListener = onClickListener
            binding.party = party
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): PartyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = PartyListItemBinding.inflate(layoutInflater, parent, false)
                return PartyViewHolder(binding)
            }
        }
    }



}

class PartyListDiffCallBack: DiffUtil.ItemCallback<String>(){
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}

// Click listener used by the adapter to passing the partys name
class OnClickListener(val clickListener: (party: String) -> Unit) {
    fun onClick(party: String){
        clickListener(party)
    }
}