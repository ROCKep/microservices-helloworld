package ru.igor.mshw.client

data class Book(val id: String?,
                val name: String,
                val authors: List<Author>,
                val genres: List<String>,
                val year: Int?)
