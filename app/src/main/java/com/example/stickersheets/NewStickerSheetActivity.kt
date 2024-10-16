package com.example.stickersheets

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.graphics.Color
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import android.widget.EditText
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import android.widget.TableLayout
import android.content.Intent
import android.util.Log




var selectedBackgroundColor: Int = Color.WHITE // Default color
var selectedTextColor: Int = Color.BLACK // Default color


class NewStickerSheetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new_sticker_sheet)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sticker_sheet_title)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val backgroundColorButton = findViewById<Button>(R.id.background_color_button)
        val textColorButton = findViewById<Button>(R.id.text_color_button)
        val newStickerSheet = findViewById<ConstraintLayout>(R.id.new_sticker_sheet)
        val saveButton = findViewById<Button>(R.id.save_sticker_sheet_button)


// Background color button click
        backgroundColorButton.setOnClickListener {
            val colors = arrayOf(
                "Bright Pink",
                "Bright Red",
                "Bright Yellow",
                "Dark Green",
                "Bright Blue",
                "Dark Purple",
                "Bright Green"
            )
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Pick Background Color")
            builder.setItems(colors) { _, selectedColor ->
                // Apply selected background color
                when (selectedColor) {
                    0 -> {
                        selectedBackgroundColor = ContextCompat.getColor(this, R.color.brightPink)
                        newStickerSheet.setBackgroundColor(selectedBackgroundColor)
                    }
                    1 -> {
                        selectedBackgroundColor = ContextCompat.getColor(this, R.color.brightRed)
                        newStickerSheet.setBackgroundColor(selectedBackgroundColor)
                    }
                    2 -> {
                        selectedBackgroundColor = ContextCompat.getColor(this, R.color.brightYellow)
                        newStickerSheet.setBackgroundColor(selectedBackgroundColor)
                    }
                    3 -> {
                        selectedBackgroundColor = ContextCompat.getColor(this, R.color.darkGreen)
                        newStickerSheet.setBackgroundColor(selectedBackgroundColor)
                    }
                    4 -> {
                        selectedBackgroundColor = ContextCompat.getColor(this, R.color.brightBlue)
                        newStickerSheet.setBackgroundColor(selectedBackgroundColor)
                    }
                    5 -> {
                        selectedBackgroundColor = ContextCompat.getColor(this, R.color.darkPurple)
                        newStickerSheet.setBackgroundColor(selectedBackgroundColor)
                    }
                    6 -> {
                        selectedBackgroundColor = ContextCompat.getColor(this, R.color.brightGreen)
                        newStickerSheet.setBackgroundColor(selectedBackgroundColor)
                    }

                    else -> newStickerSheet.setBackgroundColor(Color.WHITE)
                }

            }
            builder.show()
        }

// Text color button click
        textColorButton.setOnClickListener {
            val colors = arrayOf(
                "Black",
                "White",
                "Dark Red",
                "Light Yellow",
                "Dark Purple",
                "Light Pink",
                "Aqua Green",
                "Dark Green"
            )
            val builder = AlertDialog.Builder(this)
            val editTexts = listOf<EditText>(
                findViewById(R.id.sticker_sheet_title),
                findViewById(R.id.category_1),
                findViewById(R.id.category_2),
                findViewById(R.id.category_3),
                findViewById(R.id.category_4),
                findViewById(R.id.category_5),
                findViewById(R.id.task_1_1),
                findViewById(R.id.task_1_2),
                findViewById(R.id.task_1_3),
                findViewById(R.id.task_2_1),
                findViewById(R.id.task_2_2),
                findViewById(R.id.task_2_3),
                findViewById(R.id.task_3_1),
                findViewById(R.id.task_3_2),
                findViewById(R.id.task_3_3),
                findViewById(R.id.task_4_1),
                findViewById(R.id.task_4_2),
                findViewById(R.id.task_4_3),
                findViewById(R.id.task_5_1),
                findViewById(R.id.task_5_2),
                findViewById(R.id.task_5_3),
            )

            val stickerSheetTable = findViewById<TableLayout>(R.id.sticker_sheet_table)

            val tableCells = listOf<EditText>(
                findViewById(R.id.category_1),
                findViewById(R.id.category_2),
                findViewById(R.id.category_3),
                findViewById(R.id.category_4),
                findViewById(R.id.category_5),
                findViewById(R.id.task_1_1),
                findViewById(R.id.task_1_2),
                findViewById(R.id.task_1_3),
                findViewById(R.id.task_2_1),
                findViewById(R.id.task_2_2),
                findViewById(R.id.task_2_3),
                findViewById(R.id.task_3_1),
                findViewById(R.id.task_3_2),
                findViewById(R.id.task_3_3),
                findViewById(R.id.task_4_1),
                findViewById(R.id.task_4_2),
                findViewById(R.id.task_4_3),
                findViewById(R.id.task_5_1),
                findViewById(R.id.task_5_2),
                findViewById(R.id.task_5_3),
            )

            builder.setTitle("Pick Text Color")
            builder.setItems(colors) { _, selectedColor ->
                // Apply selected text color
                when (selectedColor) {
                    0 -> {
                        selectedTextColor = ContextCompat.getColor(this,R.color.black)
                        editTexts.forEach { it.setTextColor(Color.BLACK) }
                        tableCells.forEach { cell ->
                            cell.setBackgroundResource(R.drawable.black_border)  // Set the border drawable
                        }
                    }

                    1 -> {
                        selectedTextColor = ContextCompat.getColor(this,R.color.white)
                        editTexts.forEach { it.setTextColor(Color.WHITE) }
                        tableCells.forEach { cell ->
                            cell.setBackgroundResource(R.drawable.white_border)  // Set the border drawable
                        }
                    }

                    2 -> {
                        selectedTextColor = ContextCompat.getColor(this, R.color.textDarkRed)
                        editTexts.forEach { it.setTextColor(selectedTextColor) }
                        tableCells.forEach { cell ->
                            cell.setBackgroundResource(R.drawable.dark_red_border)  // Set the border drawable
                        }
                    }

                    3 -> {
                        selectedTextColor = ContextCompat.getColor(this, R.color.lightYellow)
                        editTexts.forEach { it.setTextColor(selectedTextColor) }
                        tableCells.forEach { cell ->
                            cell.setBackgroundResource(R.drawable.light_yellow_border)  // Set the border drawable
                        }
                    }

                    4 -> {
                        selectedTextColor = ContextCompat.getColor(this, R.color.textDarkPurple)
                        editTexts.forEach { it.setTextColor(selectedTextColor) }
                        tableCells.forEach { cell ->
                            cell.setBackgroundResource(R.drawable.dark_purple_border)  // Set the border drawable
                        }
                    }

                    5 -> {
                        selectedTextColor = ContextCompat.getColor(this, R.color.lightPink)
                        editTexts.forEach { it.setTextColor(selectedTextColor) }
                        tableCells.forEach { cell ->
                            cell.setBackgroundResource(R.drawable.light_pink_border)  // Set the border drawable
                        }
                    }

                    6 -> {
                        selectedTextColor = ContextCompat.getColor(this, R.color.lightAquaGreen)
                        editTexts.forEach { it.setTextColor(selectedTextColor) }
                        tableCells.forEach { cell ->
                            cell.setBackgroundResource(R.drawable.aqua_green_border)  // Set the border drawable
                        }
                    }

                    7 -> {
                        selectedTextColor = ContextCompat.getColor(this, R.color.textDarkGreen)
                        editTexts.forEach { it.setTextColor(selectedTextColor) }
                        tableCells.forEach { cell ->
                            cell.setBackgroundResource(R.drawable.dark_green_border)  // Set the border drawable
                        }
                    }
                }

            }
            builder.show()
        }


        saveButton.setOnClickListener {
            saveStickerSheet()
        }
    }

    fun saveStickerSheet() {
        val title = findViewById<EditText>(R.id.sticker_sheet_title).text.toString()
        val category1 = findViewById<EditText>(R.id.category_1).text.toString()
        val task1_1 = findViewById<EditText>(R.id.task_1_1).text.toString()
        val task1_2 = findViewById<EditText>(R.id.task_1_2).text.toString()
        val task1_3 = findViewById<EditText>(R.id.task_1_3).text.toString()

        val category2 = findViewById<EditText>(R.id.category_2).text.toString()
        val task2_1 = findViewById<EditText>(R.id.task_2_1).text.toString()
        val task2_2 = findViewById<EditText>(R.id.task_2_2).text.toString()
        val task2_3 = findViewById<EditText>(R.id.task_2_3).text.toString()

        val category3 = findViewById<EditText>(R.id.category_3).text.toString()
        val task3_1 = findViewById<EditText>(R.id.task_3_1).text.toString()
        val task3_2 = findViewById<EditText>(R.id.task_3_2).text.toString()
        val task3_3 = findViewById<EditText>(R.id.task_3_3).text.toString()

        val category4 = findViewById<EditText>(R.id.category_4).text.toString()
        val task4_1 = findViewById<EditText>(R.id.task_4_1).text.toString()
        val task4_2 = findViewById<EditText>(R.id.task_4_2).text.toString()
        val task4_3 = findViewById<EditText>(R.id.task_4_3).text.toString()

        val category5 = findViewById<EditText>(R.id.category_5).text.toString()
        val task5_1 = findViewById<EditText>(R.id.task_5_1).text.toString()
        val task5_2 = findViewById<EditText>(R.id.task_5_2).text.toString()
        val task5_3 = findViewById<EditText>(R.id.task_5_3).text.toString()

        // Retrieve selected colors

        // Create an Intent to start the new activity
        val intent = Intent(this, SavedStickerSheetActivity::class.java).apply {
            putExtra("STICKER_TITLE", title)
            putExtra("CATEGORY_1", category1)
            putExtra("TASK_1_1", task1_1)
            putExtra("TASK_1_2", task1_2)
            putExtra("TASK_1_3", task1_3)

            putExtra("CATEGORY_2", category2)
            putExtra("TASK_2_1", task2_1)
            putExtra("TASK_2_2", task2_2)
            putExtra("TASK_2_3", task2_3)

            putExtra("CATEGORY_3", category3)
            putExtra("TASK_3_1", task3_1)
            putExtra("TASK_3_2", task3_2)
            putExtra("TASK_3_3", task3_3)

            putExtra("CATEGORY_4", category4)
            putExtra("TASK_4_1", task4_1)
            putExtra("TASK_4_2", task4_2)
            putExtra("TASK_4_3", task4_3)

            putExtra("CATEGORY_5", category5)
            putExtra("TASK_5_1", task5_1)
            putExtra("TASK_5_2", task5_2)
            putExtra("TASK_5_3", task5_3)

            putExtra("BACKGROUND_COLOR", selectedBackgroundColor)
            putExtra("TEXT_COLOR", selectedTextColor)

            // Put other data you want to pass (like text and colors)
        }
        startActivity(intent)
    }






}




