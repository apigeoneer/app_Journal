package com.gmail.apigeoneer.journal.data

class EntryRepository private constructor(private val entryDao: FakeEntryDao) {

    fun addEntry(entry: Entry) {
        entryDao.addEntry(entry)
    }

    fun getEntries() = entryDao.getEntries()

    companion object {
        @Volatile private var instance: EntryRepository? = null

        fun getInstance(entryDao: FakeEntryDao) =
                // to stop 2 threads from executing at the same time
                instance ?: synchronized(lock = this) {
                    // Check if instance is not instantiated already
                    instance ?: EntryRepository(entryDao).also { instance = it }
                }
    }
}