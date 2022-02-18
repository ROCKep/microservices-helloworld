package ru.igor.microserviceshelloworld.client

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBodilessEntity
import org.springframework.web.reactive.function.client.awaitBody

@Component
class DataClientImpl(webClientBuilder: WebClient.Builder) : DataClient {
    private val webClient = webClientBuilder.baseUrl("http://localhost:8080").build()

    override suspend fun getBookByName(name: String): Book {

        return webClient.get()
            .uri{builder -> builder.path("/book").queryParam("name", name).build()}
            .retrieve().awaitBody()
    }

    override suspend fun addNewBook(book: Book) {
        webClient.post()
            .uri("/book").bodyValue(book)
            .retrieve().awaitBodilessEntity()
    }
}