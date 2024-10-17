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
import android.widget.Button
import android.content.Intent
import android.widget.EditText
import androidx.core.content.ContextCompat
import org.json.JSONObject




class SavedStickerSheetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved_sticker_sheet)

        // Retrieve data from the Intent
        val title = intent.getStringExtra("STICKER_TITLE")
        val backgroundColor = intent.getIntExtra("BACKGROUND_COLOR", Color.WHITE)
        val textColor = intent.getIntExtra("TEXT_COLOR", Color.BLACK)

        val category1 = intent.getStringExtra("CATEGORY_1") ?: ""
        val task1_1 = intent.getStringExtra("TASK_1_1") ?: ""
        val task1_2 = intent.getStringExtra("TASK_1_2") ?: ""
        val task1_3 = intent.getStringExtra("TASK_1_3") ?: ""

        val category2 = intent.getStringExtra("CATEGORY_2") ?: ""
        val task2_1 = intent.getStringExtra("TASK_2_1") ?: ""
        val task2_2 = intent.getStringExtra("TASK_2_2") ?: ""
        val task2_3 = intent.getStringExtra("TASK_2_3") ?: ""

        val category3 = intent.getStringExtra("CATEGORY_3") ?: ""
        val task3_1 = intent.getStringExtra("TASK_3_1") ?: ""
        val task3_2 = intent.getStringExtra("TASK_3_2") ?: ""
        val task3_3 = intent.getStringExtra("TASK_3_3") ?: ""

        val category4 = intent.getStringExtra("CATEGORY_4") ?: ""
        val task4_1 = intent.getStringExtra("TASK_4_1") ?: ""
        val task4_2 = intent.getStringExtra("TASK_4_2") ?: ""
        val task4_3 = intent.getStringExtra("TASK_4_3") ?: ""

        val category5 = intent.getStringExtra("CATEGORY_5") ?: ""
        val task5_1 = intent.getStringExtra("TASK_5_1") ?: ""
        val task5_2 = intent.getStringExtra("TASK_5_2") ?: ""
        val task5_3 = intent.getStringExtra("TASK_5_3") ?: ""

// Now create a list containing all the values
        val tableData: List<String> = listOf(
            category1, task1_1, task1_2, task1_3,
            category2, task2_1, task2_2, task2_3,
            category3, task3_1, task3_2, task3_3,
            category4, task4_1, task4_2, task4_3,
            category5, task5_1, task5_2, task5_3
        )



        // Apply the title and colors
        val titleView = findViewById<TextView>(R.id.saved_sticker_sheet_title)
        titleView.text = title
        titleView.setTextColor(textColor)

        // Set the background color of the sticker sheet layout
        val savedStickerLayout = findViewById<ConstraintLayout>(R.id.saved_sticker_sheet_layout)
        savedStickerLayout.setBackgroundColor(backgroundColor)

        val category1view = findViewById<TextView>(R.id.saved_category_1)
        category1view.setText(category1)
        category1view.setTextColor(textColor)

        val task1_1view = findViewById<TextView>(R.id.saved_task_1_1)
        task1_1view.setText(task1_1)
        task1_1view.setTextColor(textColor)

        val task1_2view = findViewById<TextView>(R.id.saved_task_1_2)
        task1_2view.setText(task1_2)
        task1_2view.setTextColor(textColor)

        val task1_3view = findViewById<TextView>(R.id.saved_task_1_3)
        task1_3view.setText(task1_3)
        task1_3view.setTextColor(textColor)


        val category2view = findViewById<TextView>(R.id.saved_category_2)
        category2view.setText(category2)
        category2view.setTextColor(textColor)

        val task2_1view = findViewById<TextView>(R.id.saved_task_2_1)
        task2_1view.setText(task2_1)
        task2_1view.setTextColor(textColor)

        val task2_2view = findViewById<TextView>(R.id.saved_task_2_2)
        task2_2view.setText(task2_2)
        task2_2view.setTextColor(textColor)

        val task2_3view = findViewById<TextView>(R.id.saved_task_2_3)
        task2_3view.setText(task2_3)
        task2_3view.setTextColor(textColor)


        val category3view = findViewById<TextView>(R.id.saved_category_3)
        category3view.setText(category3)
        category3view.setTextColor(textColor)

        val task3_1view = findViewById<TextView>(R.id.saved_task_3_1)
        task3_1view.setText(task3_1)
        task3_1view.setTextColor(textColor)

        val task3_2view = findViewById<TextView>(R.id.saved_task_3_2)
        task3_2view.setText(task3_2)
        task3_2view.setTextColor(textColor)

        val task3_3view = findViewById<TextView>(R.id.saved_task_3_3)
        task3_3view.setText(task3_3)
        task3_3view.setTextColor(textColor)


        val category4view = findViewById<TextView>(R.id.saved_category_4)
        category4view.setText(category4)
        category4view.setTextColor(textColor)

        val task4_1view = findViewById<TextView>(R.id.saved_task_4_1)
        task4_1view.setText(task4_1)
        task4_1view.setTextColor(textColor)

        val task4_2view = findViewById<TextView>(R.id.saved_task_4_2)
        task4_2view.setText(task4_2)
        task4_2view.setTextColor(textColor)

        val task4_3view = findViewById<TextView>(R.id.saved_task_4_3)
        task4_3view.setText(task4_3)
        task4_3view.setTextColor(textColor)


        val category5view = findViewById<TextView>(R.id.saved_category_5)
        category5view.setText(category5)
        category5view.setTextColor(textColor)

        val task5_1view = findViewById<TextView>(R.id.saved_task_5_1)
        task5_1view.setText(task5_1)
        task5_1view.setTextColor(textColor)

        val task5_2view = findViewById<TextView>(R.id.saved_task_5_2)
        task5_2view.setText(task5_2)
        task5_2view.setTextColor(textColor)

        val task5_3view = findViewById<TextView>(R.id.saved_task_5_3)
        task5_3view.setText(task5_3)
        task5_3view.setTextColor(textColor)


        val borderDrawable = when (textColor) {
            ContextCompat.getColor(this, R.color.black) -> R.drawable.black_border
            ContextCompat.getColor(this, R.color.white) -> R.drawable.white_border
            ContextCompat.getColor(this, R.color.textDarkRed) -> R.drawable.dark_red_border
            ContextCompat.getColor(this, R.color.lightYellow) -> R.drawable.light_yellow_border
            ContextCompat.getColor(this, R.color.textDarkPurple) -> R.drawable.dark_purple_border
            ContextCompat.getColor(this, R.color.lightPink) -> R.drawable.light_pink_border
            ContextCompat.getColor(this, R.color.lightAquaGreen) -> R.drawable.aqua_green_border
            ContextCompat.getColor(this, R.color.textDarkGreen) -> R.drawable.dark_green_border

            else -> R.drawable.black_border // Fallback to default border if color doesn't match
        }

        val borderedTableCells = listOf<TextView>(
            findViewById(R.id.saved_category_1),
            findViewById(R.id.saved_category_2),
            findViewById(R.id.saved_category_3),
            findViewById(R.id.saved_category_4),
            findViewById(R.id.saved_category_5),
            findViewById(R.id.saved_task_1_1),
            findViewById(R.id.saved_task_1_2),
            findViewById(R.id.saved_task_1_3),
            findViewById(R.id.saved_task_2_1),
            findViewById(R.id.saved_task_2_2),
            findViewById(R.id.saved_task_2_3),
            findViewById(R.id.saved_task_3_1),
            findViewById(R.id.saved_task_3_2),
            findViewById(R.id.saved_task_3_3),
            findViewById(R.id.saved_task_4_1),
            findViewById(R.id.saved_task_4_2),
            findViewById(R.id.saved_task_4_3),
            findViewById(R.id.saved_task_5_1),
            findViewById(R.id.saved_task_5_2),
            findViewById(R.id.saved_task_5_3),
        )

        // Apply the color and border to each table cell
        borderedTableCells.forEach { cell ->
            cell.setTextColor(textColor)  // Apply the text color
            cell.setBackgroundResource(borderDrawable)  // Apply the border drawable
        }


        // Find the back button
        val backButton = findViewById<Button>(R.id.back_button)

        // Set OnClickListener to return to homepage
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java) // Assuming your homepage is MainActivity
            startActivity(intent)
            finish() // Optional: Closes the current activity
        }

        // Save the sticker sheet to SharedPreferences
        val sharedPreferences = getSharedPreferences("StickerSheets", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        val stickerSheetJson = JSONObject().apply {
            put("title", title)
            put("backgroundColor", backgroundColor)
            put("textColor", textColor)
            put("tableData", tableData)
        }


// Use the title as a key and save its details as a JSON string
        editor.putString(title, stickerSheetJson.toString())
        editor.apply()

        val savedData = sharedPreferences.getString(title, "No Data Found") // Retrieve using the same key (title)


    }
}
