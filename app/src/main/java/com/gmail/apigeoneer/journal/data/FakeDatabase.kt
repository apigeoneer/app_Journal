package com.gmail.apigeoneer.journal.data

class FakeDatabase private constructor() {

    // Fake database, remember db is nothing but a holder for all the DAOs
    var entryDao = FakeEntryDao()
        private set

    // We get instances of fake database through companion obj
    // Here, we don't need a companion object if we don't want the data to persist i.e. for it to stay
    // If you use Room, you'll have to make this companion obj regardless

    // Singleton instantiation
    companion object {
        @Volatile private var _instance: FakeDatabase? = null

        fun getInstance() =
                // to stop 2 threads from executing at the same time
                _instance ?: synchronized(this) {
                    // Check if instance is not instantiated already
                    _instance ?: FakeDatabase().also { _instance = it }
                }
    }

}