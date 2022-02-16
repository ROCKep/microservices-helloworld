package ru.igor.mshw.data1

interface BookService {
    fun getByName(name: String) : Book
    fun save(book: Book)
    fun listAfterYear(year: Int): List<Book>
}