package ru.igor.mshw.client

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import reactivefeign.spring.config.ReactiveFeignClient
import reactor.core.publisher.Mono

@ReactiveFeignClient("data")
interface DataClient {
    @GetMapping("/book")
    fun getBookByName(@RequestParam name: String): Mono<Book>

    @PostMapping("/book")
    fun addNewBook(@RequestBody book: Book): Mono<Void>
}