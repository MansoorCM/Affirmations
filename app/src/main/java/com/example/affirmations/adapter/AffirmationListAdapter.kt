package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.databinding.AffirmationListItemBinding
import com.example.affirmations.model.Affirmation

class AffirmationListAdapter :
    ListAdapter<Affirmation, AffirmationListAdapter.AffirmationListViewHolder>(AffirmationDiffUtil()) {
    class AffirmationListViewHolder(
        private val context: Context,
        private val binding: AffirmationListItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(affirmation: Affirmation) {
            binding.affirmationText.text = context.getString(affirmation.stringResourceId)
            binding.affirmationImage.setImageResource(affirmation.drawableResourceId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AffirmationListViewHolder {
        val binding =
            AffirmationListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AffirmationListViewHolder(parent.context, binding)
    }

    override fun onBindViewHolder(holder: AffirmationListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        class AffirmationDiffUtil : DiffUtil.ItemCallback<Affirmation>() {
            override fun areItemsTheSame(oldItem: Affirmation, newItem: Affirmation): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Affirmation, newItem: Affirmation): Boolean {
                return oldItem == newItem
            }
        }
    }
}