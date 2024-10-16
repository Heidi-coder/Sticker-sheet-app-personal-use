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
            stickerSheetTitles.add(key)
        }

        stickerSheetTitles.clear() // Clear the list to avoid duplicates
        for (entry in allEntries) {
            entry.key?.let { stickerSheetTitles.add(it) } // Add non-null keys only
        }


        // Set up RecyclerView
        stickerSheetsRecyclerView.layoutManager = LinearLayoutManager(this)
        stickerSheetAdapter = StickerSheetAdapter(stickerSheetTitles) { title ->
            val intent = Intent(this, SavedStickerSheetActivity::class.java)
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

        stickerSheetAdapter.setOnItemClickListener { title ->
            // Pass the title to SavedStickerSheetActivity and open the sheet
            val intent = Intent(this, SavedStickerSheetActivity::class.java)
            intent.putExtra("title", title)
            startActivity(intent)
        }

    }
}