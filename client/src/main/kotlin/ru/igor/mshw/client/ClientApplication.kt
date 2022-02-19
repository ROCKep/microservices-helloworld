package ru.igor.mshw.client

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import reactivefeign.spring.config.EnableReactiveFeignClients

@SpringBootApplication
@EnableReactiveFeignClients
class ClientApplication

fun main(args: Array<String>) {
	runApplication<ClientApplication>(*args)
}
