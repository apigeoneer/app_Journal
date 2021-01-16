package com.gmail.apigeoneer.journal.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gmail.apigeoneer.journal.data.EntryRepository

class EntryViewModelFactory(private val entryRepository: EntryRepository)
    :ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return EntryViewModelFactory(entryRepository) as T
    }
}