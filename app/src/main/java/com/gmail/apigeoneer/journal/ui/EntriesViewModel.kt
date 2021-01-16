package com.gmail.apigeoneer.journal.ui

import androidx.lifecycle.ViewModel
import com.gmail.apigeoneer.journal.data.Entry
import com.gmail.apigeoneer.journal.data.EntryRepository

class EntriesViewModel(private val entryRepository: EntryRepository)
    :ViewModel() {

    fun getEntries() = entryRepository.getEntries()

    fun addEntry(entry: Entry) = entryRepository.addEntry(entry)
}