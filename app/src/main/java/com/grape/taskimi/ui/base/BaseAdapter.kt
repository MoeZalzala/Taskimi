package com.grape.taskimi.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.grape.taskimi.BR
import com.grape.taskimi.util.Diffutils

interface BaseInteractionListener

abstract class BaseAdapter<T>(
    private var item: List<T>,
    private val listener: BaseInteractionListener
) :
    RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {

    abstract val layoutId: Int
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseAdapter.BaseViewHolder {
        return ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutId,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseAdapter.BaseViewHolder, position: Int) {
        val currentItem = item[position]
        when(holder){
            is ItemViewHolder ->{
                holder.binding.setVariable(BR.item, currentItem)
            }
        }
    }

    override fun getItemCount() = item.size

    fun getItem() = item

    fun setItems(newItemList: List<T>) {
        val diffUtil = DiffUtil.calculateDiff(Diffutils(item, newItemList){
            oldItem, newItem ->
            areItemsSame(oldItem, newItem)
        })
        item = newItemList
        diffUtil.dispatchUpdatesTo(this)
    }

    open fun areItemsSame(oldItem: T, newItems: T) = oldItem?.equals(newItems) == true

    class ItemViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding)

    abstract class BaseViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

}