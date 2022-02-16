package ru.igor.mshw.data1

import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

private val log = KotlinLogging.logger {  }

@Service
class BookServiceImpl(val bookRepository: BookRepository) : BookService {
    @Transactional(readOnly = true)
    override fun getByName(name: String): Book =
        bookRepository.findByName(name)
            ?: throw NoSuchElementException("Нет такой книги: $name")

    @Transactional
    override fun save(book: Book) {
        if (bookRepository.findByName(book.name) != null)
            throw IllegalArgumentException("Такая книга уже существует: ${book.name}")

        val saved = bookRepository.save(book)
        log.debug {"Saved id is ${saved.id}"}
    }

    @Transactional(readOnly = true)
    override fun listAfterYear(year: Int): List<Book> =
        bookRepository.findByYearGreaterThan(year)
}