package com.gmail.apigeoneer.journal.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.gmail.apigeoneer.journal.R
import com.gmail.apigeoneer.journal.data.Entry
import com.gmail.apigeoneer.journal.utils.InjectorUtils
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var entryText: TextView
    private lateinit var entryEditText: EditText
    private lateinit var dateEditText: EditText
    private lateinit var sendImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        entryText = findViewById(R.id.entry_text)
        entryEditText = findViewById(R.id.entry_edit_text)
        dateEditText = findViewById(R.id.date_edit_text)
        sendImage = findViewById(R.id.send_image)

        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectorUtils.provideEntriesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
                .get(EntriesViewModel::class.java)

        viewModel.getEntries().observe(this, Observer { entries ->
            val stringBuilder = StringBuilder()
            entries.forEach { entry ->
                stringBuilder.append("$entry\n\n")
            }
            entryText.text = stringBuilder.toString()
        })

        sendImage.setOnClickListener {
            val entry = Entry(entryEditText.text.toString(), dateEditText.text.toString())
            viewModel.addEntry(entry)
            entryEditText.setText("")
            dateEditText.setText("")
        }

    }
}