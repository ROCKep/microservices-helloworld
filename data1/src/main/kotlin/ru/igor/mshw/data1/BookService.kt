package ru.igor.mshw.data1

import kotlinx.coroutines.flow.Flow

interface BookService {
    suspend fun getByName(name: String) : Book
    suspend fun save(book: Book)
    fun listAfterYear(year: Int): Flow<Book>
}