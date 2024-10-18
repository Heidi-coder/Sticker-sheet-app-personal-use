package com.example.stickersheets

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import androidx.constraintlayout.widget.ConstraintLayout
import android.widget.Button
import android.widget.TextView
import org.json.JSONObject

class ReopenedStickerSheetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reopened_sticker_sheet)

        // Retrieve data from the Intent
        val title = intent.getStringExtra("TITLE")
        val backgroundColor = intent.getIntExtra("BACKGROUND_COLOR", Color.WHITE)
        val textColor = intent.getIntExtra("TEXT_COLOR", Color.BLACK)

        // Apply the title, background, and text colors
        val titleView = findViewById<TextView>(R.id.reopened_sticker_sheet_title)
        titleView.text = title
        titleView.setTextColor(textColor)
        val layout = findViewById<ConstraintLayout>(R.id.reopened_sticker_sheet_layout)
        layout.setBackgroundColor(backgroundColor)

        // Load table data from SharedPreferences
        val sharedPreferences = getSharedPreferences("StickerSheets", MODE_PRIVATE)
        val savedData = sharedPreferences.getString(title, null)  // Use null as default

        // If savedData exists, parse and apply it
        savedData?.let {
            // Parse the JSON object
            val jsonObject = JSONObject(it)

            // Retrieve individual fields directly
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

            // Apply the categories and tasks to the respective TextViews
            findViewById<TextView>(R.id.reopened_category_1).apply {
                text = category1
                setTextColor(textColor)
            }
            findViewById<TextView>(R.id.reopened_task_1_1).apply {
                text = task1_1
                setTextColor(textColor)
            }
            findViewById<TextView>(R.id.reopened_task_1_2).apply {
                text = task1_2
                setTextColor(textColor)
            }
            findViewById<TextView>(R.id.reopened_task_1_3).apply {
                text = task1_3
                setTextColor(textColor)
            }

            findViewById<TextView>(R.id.reopened_category_2).apply {
                text = category2
                setTextColor(textColor)
            }
            findViewById<TextView>(R.id.reopened_task_2_1).apply {
                text = task2_1
                setTextColor(textColor)
            }
            findViewById<TextView>(R.id.reopened_task_2_2).apply {
                text = task2_2
                setTextColor(textColor)
            }
            findViewById<TextView>(R.id.reopened_task_2_3).apply {
                text = task2_3
                setTextColor(textColor)
            }

            findViewById<TextView>(R.id.reopened_category_3).apply {
                text = category3
                setTextColor(textColor)
            }
            findViewById<TextView>(R.id.reopened_task_3_1).apply {
                text = task3_1
                setTextColor(textColor)
            }
            findViewById<TextView>(R.id.reopened_task_3_2).apply {
                text = task3_2
                setTextColor(textColor)
            }
            findViewById<TextView>(R.id.reopened_task_3_3).apply {
                text = task3_3
                setTextColor(textColor)
            }

            findViewById<TextView>(R.id.reopened_category_4).apply {
                text = category4
                setTextColor(textColor)
            }
            findViewById<TextView>(R.id.reopened_task_4_1).apply {
                text = task4_1
                setTextColor(textColor)
            }
            findViewById<TextView>(R.id.reopened_task_4_2).apply {
                text = task4_2
                setTextColor(textColor)
            }
            findViewById<TextView>(R.id.reopened_task_4_3).apply {
                text = task4_3
                setTextColor(textColor)
            }

            findViewById<TextView>(R.id.reopened_category_5).apply {
                text = category5
                setTextColor(textColor)
            }
            findViewById<TextView>(R.id.reopened_task_5_1).apply {
                text = task5_1
                setTextColor(textColor)
            }
            findViewById<TextView>(R.id.reopened_task_5_2).apply {
                text = task5_2
                setTextColor(textColor)
            }
            findViewById<TextView>(R.id.reopened_task_5_3).apply {
                text = task5_3
                setTextColor(textColor)
            }
        }

        val backButton = findViewById<Button>(R.id.back_button)

        // Set OnClickListener to go back to the previous activity
        backButton.setOnClickListener {
            onBackPressed()  // Call this method to return to the previous activity
        }
    }
}
