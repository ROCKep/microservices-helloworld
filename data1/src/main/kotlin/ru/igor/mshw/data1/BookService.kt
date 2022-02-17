package ru.igor.mshw.data1

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface BookService {
    fun getByName(name: String) : Mono<Book>
    fun save(book: Book) : Mono<Void>
    fun listAfterYear(year: Int): Flux<Book>
}