package com.example.stickersheets

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.widget.Button
import android.view.View
import android.widget.ArrayAdapter
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import androidx.core.content.ContextCompat




class CurrentStickerSheetsActivity : AppCompatActivity() {

    private lateinit var noSheetsMessage: TextView
    private lateinit var stickerSheetsRecyclerView: RecyclerView
    private lateinit var stickerSheetAdapter: StickerSheetAdapter


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
        stickerSheetsRecyclerView =
            findViewById(R.id.stickerSheetsRecyclerView)
        val backToHomeButton = findViewById<Button>(R.id.backToHomeButton)

        backToHomeButton.setOnClickListener {
            finish() // Close this activity and return to the previous one
        }

        // Load your sticker sheets data here
        val sharedPreferences = getSharedPreferences("StickerSheets", MODE_PRIVATE)
        val allEntries = sharedPreferences.all

        // Extract the titles (which will be the keys)
        val stickerSheetTitles = ArrayList<String>()
        for ((key, _) in allEntries) {
            key?.let { stickerSheetTitles.add(it) }
        }

        // List of background colors
        val backgroundColors = listOf(
            ContextCompat.getColor(this, R.color.brightPink),
            ContextCompat.getColor(this, R.color.brightRed),
            ContextCompat.getColor(this, R.color.brightYellow),
            ContextCompat.getColor(this, R.color.darkGreen),
            ContextCompat.getColor(this, R.color.brightBlue),
            ContextCompat.getColor(this, R.color.darkPurple),
            ContextCompat.getColor(this, R.color.brightGreen)
        )

// List of text colors
        val textColors = listOf(
            ContextCompat.getColor(this, R.color.black),
            ContextCompat.getColor(this, R.color.white),
            ContextCompat.getColor(this, R.color.textDarkRed),
            ContextCompat.getColor(this, R.color.lightYellow),
            ContextCompat.getColor(this, R.color.textDarkPurple),
            ContextCompat.getColor(this, R.color.lightPink),
            ContextCompat.getColor(this, R.color.lightAquaGreen),
            ContextCompat.getColor(this, R.color.textDarkGreen)
        )

        // Set up RecyclerView
        stickerSheetsRecyclerView.layoutManager = LinearLayoutManager(this)
        stickerSheetAdapter = StickerSheetAdapter(stickerSheetTitles, this, backgroundColors, textColors) { title ->
            val intent = Intent(this, ReopenedStickerSheetActivity::class.java)
            intent.putExtra("title", title)
            startActivity(intent)
        }

        stickerSheetsRecyclerView.adapter = stickerSheetAdapter

        stickerSheetAdapter.notifyDataSetChanged() // Ensure the RecyclerView is aware of data changes



        // Check if there are no sheets and update visibility accordingly
        if (stickerSheetTitles.isEmpty()) {
            noSheetsMessage.visibility = View.VISIBLE
            stickerSheetsRecyclerView.visibility = View.GONE // Hide RecyclerView if no sheets
        } else {
            noSheetsMessage.visibility = View.GONE // Hide message if there are sheets
            stickerSheetsRecyclerView.visibility = View.VISIBLE // Show RecyclerView
        }


    }
}