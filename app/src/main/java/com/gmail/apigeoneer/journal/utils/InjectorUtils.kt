package com.gmail.apigeoneer.journal.utils

import com.gmail.apigeoneer.journal.data.EntryRepository
import com.gmail.apigeoneer.journal.data.FakeDatabase
import com.gmail.apigeoneer.journal.ui.EntriesViewModelFactory

object InjectorUtils {

    fun provideEntriesViewModelFactory(): EntriesViewModelFactory {
        // Creating all the dependencies for EntriesViewModelFactory
        val entryRepository = EntryRepository.getInstance(FakeDatabase.getInstance().entryDao)
        return EntriesViewModelFactory(entryRepository)
    }
}