package ru.igor.mshw.data1

import org.springframework.data.mongodb.repository.MongoRepository

interface BookRepository : MongoRepository<Book, String> {
    fun findByName(name: String) : Book?
    fun findByYearGreaterThan(year: Int) : List<Book>
}