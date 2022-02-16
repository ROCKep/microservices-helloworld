package ru.igor.mshw.data1

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("books")
data class Book(@Id val id: String?,
                val name: String,
                val authors: List<Author>,
                val genres: List<String>,
                val year: Int?)
