package ru.igor.mshw.gateway

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod.GET
import org.springframework.http.HttpMethod.POST

@Configuration
class RoutingConfiguration {
    @Bean
    fun routes(builder: RouteLocatorBuilder): RouteLocator =
        builder.routes()
            .route("getBookByName") { p ->
                p.path("/book/*")
                    .and().method(GET)
                    .filters { f ->
                        f.rewritePath("/book/(?<name>.*)", "/\${name}")
                    }
                    .uri("lb://client") }
            .route("getBooksAfterYear") { p ->
                p.path("/books/*")
                    .and().method(GET)
                    .filters { f ->
                        f.rewritePath("/books/(?<year>.*)", "/books/\${year}")
                    }
                    .uri("lb://data")
            }
            .route("addNewBook") { p ->
                p.path("/book")
                    .and().method(POST)
                    .filters { f ->
                        f.rewritePath("/book", "/")
                    }
                    .uri("lb://client")
            }
            .build()
}