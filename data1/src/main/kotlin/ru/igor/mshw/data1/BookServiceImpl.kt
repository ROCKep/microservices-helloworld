package ru.igor.mshw.data1

import mu.KotlinLogging
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty
import reactor.kotlin.core.publisher.toMono

private val log = KotlinLogging.logger {  }

@Service
class BookServiceImpl(private val bookRepository: BookRepository) : BookService {
    override fun getByName(name: String): Mono<Book> =
        bookRepository.findByName(name)
            .switchIfEmpty {
                NoSuchElementException("Нет такой книги: $name").toMono()
            }

    override fun save(book: Book): Mono<Void> =
        bookRepository.findByName(book.name)
            .hasElement()
            .flatMap { isPresent ->
                if (isPresent)
                    IllegalArgumentException("Такая книга уже существует: ${book.name}").toMono()
                else bookRepository.save(book)
            }
            .doOnNext { saved -> log.debug { "Saved id is ${saved.id}" } }
            .then()

    override fun listAfterYear(year: Int): Flux<Book> =
        bookRepository.findByYearGreaterThan(year)
}