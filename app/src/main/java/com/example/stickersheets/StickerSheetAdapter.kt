package com.example.stickersheets

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.core.content.ContextCompat
import android.content.Intent
import org.json.JSONObject

class StickerSheetAdapter(
    private val stickerSheets: List<String>,
    private val context: Context,
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

    data class StickerSheet(
        val title: String,
        val backgroundColor: Int,
        val textColor: Int,
        val tableData: List<String>
    )

    fun getStickerSheetFromSharedPreferences(title: String): StickerSheet? {
        val sharedPreferences = context.getSharedPreferences("StickerSheets", Context.MODE_PRIVATE)
        val savedData = sharedPreferences.getString(title, null) ?: return null

        return try {
            val stickerSheetJson = JSONObject(savedData)
            val backgroundColor = stickerSheetJson.getInt("backgroundColor")
            val textColor = stickerSheetJson.getInt("textColor")
            val tableData = stickerSheetJson.getString("tableData").split(",")

            StickerSheet(title, backgroundColor, textColor, tableData)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val stickerSheetTitle = stickerSheets[position]
        holder.stickerTitle.text = stickerSheetTitle

        // Retrieve the sticker sheet data from SharedPreferences
        val stickerSheet = getStickerSheetFromSharedPreferences(stickerSheetTitle)

        if (stickerSheet != null) {
            // Apply the colors to the item view
            holder.itemView.setBackgroundColor(stickerSheet.backgroundColor)
            holder.stickerTitle.setTextColor(stickerSheet.textColor)
        } else {
            // Fallback colors if not found
            holder.itemView.setBackgroundColor(backgroundColors.getOrNull(position) ?: ContextCompat.getColor(context, R.color.white))
            holder.stickerTitle.setTextColor(textColors.getOrNull(position) ?: ContextCompat.getColor(context, R.color.black))
        }

        // Attach click listener to each sticker sheet
        holder.itemView.setOnClickListener {
            val intent = Intent(context, SavedStickerSheetActivity::class.java).apply {
                putExtra("TITLE", stickerSheetTitle)
                stickerSheet?.let {
                    putExtra("BACKGROUND_COLOR", it.backgroundColor)
                    putExtra("TEXT_COLOR", it.textColor)
                    putStringArrayListExtra("TABLE_DATA", ArrayList(it.tableData))
                }
            }
            context.startActivity(intent)
        }
    }
}
