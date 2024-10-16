package com.example.stickersheets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class StickerSheetAdapter(
    private val stickerSheets: List<String>,
    private val clickListener: (String) -> Unit
) : RecyclerView.Adapter<StickerSheetAdapter.ViewHolder>() {

    // ViewHolder class for handling individual list items
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val stickerTitle: TextView = itemView.findViewById(R.id.stickerTitleTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sticker_sheet_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = stickerSheets.size

    private var onItemClickListener: ((String) -> Unit)? = null

    // Set the listener
    fun setOnItemClickListener(listener: (String) -> Unit) {
        this.onItemClickListener = listener
    }

    // ViewHolder and other methods...

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val stickerSheetTitle = stickerSheets[position]
        holder.stickerTitle.text = stickerSheetTitle

        // Attach click listener to each sticker sheet
        holder.itemView.setOnClickListener {
            clickListener(stickerSheetTitle)
        }
    }

}
