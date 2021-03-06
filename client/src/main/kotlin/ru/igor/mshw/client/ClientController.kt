package ru.igor.mshw.client

import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ClientController(private val dataClient: DataClient) {
    @GetMapping("/{name}")
    suspend fun getBookByName(@PathVariable name: String): Book =
        dataClient.getBookByName(name).awaitSingle()

    @PostMapping("/")
    suspend fun addNewBook(@RequestBody book: Book) {
        dataClient.addNewBook(book).awaitSingleOrNull()
    }
}