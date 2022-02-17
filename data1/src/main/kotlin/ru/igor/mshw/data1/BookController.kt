package ru.igor.mshw.data1

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class BookController(private val bookService: BookService) {
    @GetMapping("/book")
    fun getBookByName(@RequestParam name: String) : Mono<Book> =
        bookService.getByName(name)

    @GetMapping("/books/{year}")
    fun listBooksAfterYear(@PathVariable year: Int): Flux<Book> =
        bookService.listAfterYear(year)

    @PostMapping("/book")
    fun addNewBook(@RequestBody book: Book) : Mono<Void> =
        bookService.save(book)
}