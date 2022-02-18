package ru.igor.mshw.data1

import kotlinx.coroutines.flow.Flow
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val log = KotlinLogging.logger {  }

@Service
class BookServiceImpl(private val bookRepository: BookRepository) : BookService {
    override suspend fun getByName(name: String): Book =
        bookRepository.findByName(name)
            ?: throw NoSuchElementException("Нет такой книги: $name")

    override suspend fun save(book: Book) {
        val existingBook = bookRepository.findByName(book.name)
        if (existingBook != null) {
            throw IllegalArgumentException("Такая книга уже существует: ${book.name}")
        }
        val savedBook = bookRepository.save(book)
        log.debug { "Saved id is ${savedBook.id}" }
    }

    override fun listAfterYear(year: Int): Flow<Book> =
        bookRepository.findByYearGreaterThan(year)
}