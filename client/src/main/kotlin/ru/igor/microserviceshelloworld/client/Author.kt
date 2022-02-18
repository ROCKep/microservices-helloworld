package ru.igor.microserviceshelloworld.client

import java.time.LocalDate

data class Author(val name: String,
                  val dateOfBirth: LocalDate?)
