package com.myfirstandroidapp.bookmark

import androidx.recyclerview.widget.DiffUtil

class RecommendationDiffCallback(private val oldList: List<Recommendation>,
                                 private val newList: List<Recommendation>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList == newList
    }
}
