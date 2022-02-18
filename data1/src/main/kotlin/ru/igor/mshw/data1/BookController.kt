package ru.igor.mshw.data1

import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.*

@RestController
class BookController(private val bookService: BookService) {
    @GetMapping("/book")
    suspend fun getBookByName(@RequestParam name: String) : Book =
        bookService.getByName(name)

    @GetMapping("/books/{year}")
    fun listBooksAfterYear(@PathVariable year: Int): Flow<Book> =
        bookService.listAfterYear(year)

    @PostMapping("/book")
    suspend fun addNewBook(@RequestBody book: Book) {
        bookService.save(book)
    }
}