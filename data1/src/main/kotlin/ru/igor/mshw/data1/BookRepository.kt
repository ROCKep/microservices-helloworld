package ru.igor.mshw.data1

import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface BookRepository : CoroutineCrudRepository<Book, String> {
    suspend fun findByName(name: String) : Book?
    fun findByYearGreaterThan(year: Int) : Flow<Book>
}