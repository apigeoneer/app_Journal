package com.gmail.apigeoneer.journal.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeEntryDao {
    private val entryList = mutableListOf<Entry>()
    private val entries = MutableLiveData<List<Entry>>()

    init {
        entries.value = entryList
    }

    fun addEntry(entry: Entry) {
        entryList.add(entry)
        entries.value = entryList
    }

    fun getEntries() = entries as LiveData<List<Entry>>
}