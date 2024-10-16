package com.example.stickersheets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.graphics.Color
import androidx.core.content.ContextCompat
import android.content.Intent



class StickerSheetAdapter(
    private val stickerSheets: List<String>,
    private val backgroundColors: List<Int>, // List of background colors
    private val textColors: List<Int>, // List of text colors
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

    override fun getItemCount(): Int {
        return stickerSheets.size
    }

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
            // Create the intent to start SavedStickerSheetActivity
            val intent = Intent(holder.itemView.context, SavedStickerSheetActivity::class.java).apply {
                // Pass the title and any other data you need
                putExtra("TITLE", stickerSheetTitle)
                putExtra("BACKGROUND_COLOR", backgroundColors[position])
                putExtra("TEXT_COLOR", textColors[position])
            }
            // Start the activity using the context from the itemView
            holder.itemView.context.startActivity(intent)
        }
        holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.lightPink))
    }

}


