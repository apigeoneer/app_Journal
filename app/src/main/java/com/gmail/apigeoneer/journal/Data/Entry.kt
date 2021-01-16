package com.gmail.apigeoneer.journal.Data

data class Entry(val entryText: String,
                 val date: String) {

    override fun toString(): String {
        return "$date   $entryText"
    }
}