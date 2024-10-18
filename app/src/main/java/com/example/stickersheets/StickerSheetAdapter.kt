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
import org.json.JSONArray


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
        val category1: String,
        val task1_1: String,
        val task1_2: String,
        val task1_3: String,
        val category2: String,
        val task2_1: String,
        val task2_2: String,
        val task2_3: String,
        val category3: String,
        val task3_1: String,
        val task3_2: String,
        val task3_3: String,
        val category4: String,
        val task4_1: String,
        val task4_2: String,
        val task4_3: String,
        val category5: String,
        val task5_1: String,
        val task5_2: String,
        val task5_3: String
    )

    private fun getStickerSheetFromSharedPreferences(title: String): StickerSheet? {
        val sharedPreferences = context.getSharedPreferences("StickerSheets", Context.MODE_PRIVATE)
        val savedData = sharedPreferences.getString(title, null)

        return try {
            savedData?.let {
                val jsonObject = JSONObject(it)

                // Extract the necessary properties
                val backgroundColor = jsonObject.getInt("backgroundColor")
                val textColor = jsonObject.getInt("textColor")

                // Extract categories and tasks
                val category1 = jsonObject.getString("category1")
                val task1_1 = jsonObject.getString("task_1_1")
                val task1_2 = jsonObject.getString("task_1_2")
                val task1_3 = jsonObject.getString("task_1_3")
                val category2 = jsonObject.getString("category2")
                val task2_1 = jsonObject.getString("task_2_1")
                val task2_2 = jsonObject.getString("task_2_2")
                val task2_3 = jsonObject.getString("task_2_3")
                val category3 = jsonObject.getString("category3")
                val task3_1 = jsonObject.getString("task_3_1")
                val task3_2 = jsonObject.getString("task_3_2")
                val task3_3 = jsonObject.getString("task_3_3")
                val category4 = jsonObject.getString("category4")
                val task4_1 = jsonObject.getString("task_4_1")
                val task4_2 = jsonObject.getString("task_4_2")
                val task4_3 = jsonObject.getString("task_4_3")
                val category5 = jsonObject.getString("category5")
                val task5_1 = jsonObject.getString("task_5_1")
                val task5_2 = jsonObject.getString("task_5_2")
                val task5_3 = jsonObject.getString("task_5_3")

                // Create and return the StickerSheet object
                StickerSheet(
                    title = jsonObject.getString("title"),
                    backgroundColor = backgroundColor,
                    textColor = textColor,
                    category1 = category1,
                    task1_1 = task1_1,
                    task1_2 = task1_2,
                    task1_3 = task1_3,
                    category2 = category2,
                    task2_1 = task2_1,
                    task2_2 = task2_2,
                    task2_3 = task2_3,
                    category3 = category3,
                    task3_1 = task3_1,
                    task3_2 = task3_2,
                    task3_3 = task3_3,
                    category4 = category4,
                    task4_1 = task4_1,
                    task4_2 = task4_2,
                    task4_3 = task4_3,
                    category5 = category5,
                    task5_1 = task5_1,
                    task5_2 = task5_2,
                    task5_3 = task5_3
                )
            }
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
            val intent = Intent(context, ReopenedStickerSheetActivity::class.java).apply {
                putExtra("TITLE", stickerSheetTitle)
                stickerSheet?.let {
                    putExtra("BACKGROUND_COLOR", it.backgroundColor)
                    putExtra("TEXT_COLOR", it.textColor)

                    putExtra("CATEGORY_1", it.category1)
                    putExtra("TASK_1_1", it.task1_1)
                    putExtra("TASK_1_2", it.task1_2)
                    putExtra("TASK_1_3", it.task1_3)
                    putExtra("CATEGORY_2", it.category2)
                    putExtra("TASK_2_1", it.task2_1)
                    putExtra("TASK_2_2", it.task2_2)
                    putExtra("TASK_2_3", it.task2_3)
                    putExtra("CATEGORY_3", it.category3)
                    putExtra("TASK_3_1", it.task3_1)
                    putExtra("TASK_3_2", it.task3_2)
                    putExtra("TASK_3_3", it.task3_3)
                    putExtra("CATEGORY_4", it.category4)
                    putExtra("TASK_4_1", it.task4_1)
                    putExtra("TASK_4_2", it.task4_2)
                    putExtra("TASK_4_3", it.task4_3)
                    putExtra("CATEGORY_5", it.category5)
                    putExtra("TASK_5_1", it.task5_1)
                    putExtra("TASK_5_2", it.task5_2)
                    putExtra("TASK_5_3", it.task5_3)
                }
            }
            context.startActivity(intent)
        }
    }
}
