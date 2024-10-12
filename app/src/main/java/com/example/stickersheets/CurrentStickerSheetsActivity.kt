package com.example.stickersheets

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.widget.ListView
import android.widget.Button
import android.view.View
import android.widget.ArrayAdapter


class CurrentStickerSheetsActivity : AppCompatActivity() {

    private lateinit var noSheetsMessage: TextView
    private lateinit var stickerSheetsListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_current_sticker_sheets)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.current_sticker_sheets)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        noSheetsMessage = findViewById(R.id.noSheetsMessage)
        stickerSheetsListView = findViewById(R.id.stickerSheetsListView)
        val backToHomeButton = findViewById<Button>(R.id.backToHomeButton)

        backToHomeButton.setOnClickListener {
            finish() // Close this activity and return to the previous one
        }

        // Load your sticker sheets data here
        val stickerSheets = loadStickerSheets() // Replace with your actual method to load sheets

        if (stickerSheets.isEmpty()) {
            noSheetsMessage.visibility = View.VISIBLE
        } else {
            stickerSheetsListView.visibility = View.VISIBLE
            // Set up your ListView adapter to display the sticker sheets here
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, stickerSheets)
            stickerSheetsListView.adapter = adapter
        }
    }
    private fun loadStickerSheets(): List<String> {
        // Replace with your logic to load sticker sheets
        return emptyList() // Placeholder: return an empty list for testing
    }
}