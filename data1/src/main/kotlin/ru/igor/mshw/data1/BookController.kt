package ru.igor.mshw.data1

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(val bookService: BookService) {
    @GetMapping("/book")
    fun getBookByName(@RequestParam name: String) : Book =
        bookService.getByName(name)

    @GetMapping("/books/{year}")
    fun listBooksAfterYear(@PathVariable year: Int): List<Book> =
        bookService.listAfterYear(year)

    @PostMapping("/book")
    fun addNewBook(@RequestBody book: Book) =
        bookService.save(book)
}