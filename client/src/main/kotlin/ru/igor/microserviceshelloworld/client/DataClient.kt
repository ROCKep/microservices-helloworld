package ru.igor.microserviceshelloworld.client

interface DataClient {
    suspend fun getBookByName(name: String): Book
    suspend fun addNewBook(book: Book)
}