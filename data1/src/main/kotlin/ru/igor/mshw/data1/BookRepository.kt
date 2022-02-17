package ru.igor.mshw.data1

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface BookRepository : ReactiveMongoRepository<Book, String> {
    fun findByName(name: String) : Mono<Book>
    fun findByYearGreaterThan(year: Int) : Flux<Book>
}