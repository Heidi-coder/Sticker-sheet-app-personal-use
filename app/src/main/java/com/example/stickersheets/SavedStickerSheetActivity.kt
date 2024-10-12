package com.example.stickersheets

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.graphics.Color
import androidx.constraintlayout.widget.ConstraintLayout
import android.util.Log


class SavedStickerSheetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved_sticker_sheet)

        // Retrieve data from the Intent
        val title = intent.getStringExtra("STICKER_TITLE")
        val backgroundColor = intent.getIntExtra("BACKGROUND_COLOR", Color.WHITE)
        val textColor = intent.getIntExtra("TEXT_COLOR", Color.BLACK)

        val category1 = intent.getStringExtra("CATEGORY_1")
        val task1_1 = intent.getStringExtra("Task_1_1")
        val task1_2 = intent.getStringExtra("TASK_1_2")
        val task1_3 = intent.getStringExtra("TASK_1_3")

        val category2 = intent.getStringExtra("CATEGORY_2")
        val task2_1 = intent.getStringExtra("TASK_2_1")
        val task2_2 = intent.getStringExtra("TASK_2_2")
        val task2_3 = intent.getStringExtra("TASK_2_3")

        val category3 = intent.getStringExtra("CATEGORY_3")
        val task3_1 = intent.getStringExtra("TASK_3_1")
        val task3_2 = intent.getStringExtra("TASK_3_2")
        val task3_3 = intent.getStringExtra("TASK_3_3")

        val category4 = intent.getStringExtra("CATEGORY_4")
        val task4_1 = intent.getStringExtra("TASK_4_1")
        val task4_2 = intent.getStringExtra("TASK_4_2")
        val task4_3 = intent.getStringExtra("TASK_4_3")

        val category5 = intent.getStringExtra("CATEGORY_5")
        val task5_1 = intent.getStringExtra("TASK_5_1")
        val task5_2 = intent.getStringExtra("TASK_5_2")
        val task5_3 = intent.getStringExtra("TASK_5_3")

        // Apply the title and colors
        val titleView = findViewById<TextView>(R.id.saved_sticker_sheet_title)
        titleView.text = title
        titleView.setTextColor(textColor)

        // Set the background color of the sticker sheet layout
        val savedStickerLayout = findViewById<ConstraintLayout>(R.id.saved_sticker_sheet_layout)
        savedStickerLayout.setBackgroundColor(backgroundColor)
    }
}
