package com.dolotdev.listotodo.presentation.page.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.ColorUtils
import androidx.recyclerview.widget.RecyclerView
import com.dolotdev.listotodo.R
import com.dolotdev.listotodo.data.model.ItemToDo
import kotlinx.android.synthetic.main.item_to_do.view.*
import java.text.SimpleDateFormat
import java.util.*

class ItemListAdapter : RecyclerView.Adapter<ItemListAdapter.VH>() {

    private var items: List<Any>? = null

    var onItemClickListener: (Long) -> Unit = {}
    var onDeleteItemClickListener: (Long) -> Unit = {}

    fun setData(data: List<Any>?) {
        this.items = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val layoutRes = when (viewType) {
            ViewType.ITEM_TO_DO.ordinal -> R.layout.item_to_do
            else -> R.layout.item_empty_data
        }
        val view: View =
            LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)
        return VH(view)
    }

    override fun getItemCount(): Int = items?.size ?: 0

    override fun getItemViewType(position: Int): Int {
        return when (items?.get(position)) {
            is ItemToDo -> ViewType.ITEM_TO_DO.ordinal
            else -> ViewType.EMPTY_DATA.ordinal
        }
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        when (holder.itemViewType) {
            ViewType.ITEM_TO_DO.ordinal -> bindItemToDo(holder, position)
        }
    }

    private fun bindItemToDo(holder: VH, position: Int) {
        holder.itemView.apply {
            val item = items?.get(position) as ItemToDo

            itemId.text = item.id.toString()
            name.text = item.name
            creationDate.text = SimpleDateFormat(
                "MM/dd/yyyy HH:mm:ss",
                Locale.getDefault()
            ).format(Date(item.creationDate))

            clickCounter.text = item.clickCounter.toString()

            viewBackground.apply {
                shadowColor = ColorUtils.setAlphaComponent(item.color, (255 * 0.5).toInt())
                bgColor = item.color
            }

            setOnClickListener { onItemClickListener(item.id) }
            delete.setOnClickListener { onDeleteItemClickListener(item.id) }

        }
    }

    class VH(view: View) : RecyclerView.ViewHolder(view)
    private enum class ViewType {
        ITEM_TO_DO,
        EMPTY_DATA
    }
}