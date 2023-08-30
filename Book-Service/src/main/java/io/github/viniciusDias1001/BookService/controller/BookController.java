package io.github.viniciusDias1001.BookService.controller;

import io.github.viniciusDias1001.BookService.model.Book;
import io.github.viniciusDias1001.BookService.proxy.CambioProxy;
import io.github.viniciusDias1001.BookService.repository.BookRepository;
import io.github.viniciusDias1001.BookService.response.Cambio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;

@RestController
@RequestMapping("book-service")
@Tag(name = "Book endpoint")
public class BookController {
    @Autowired
    private Environment environment;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CambioProxy cambioProxy;

    public BookController(Environment environment, BookRepository bookRepository) {
        this.environment = environment;
        this.bookRepository = bookRepository;
    }


    @GetMapping(value = "/{id}/{currency}")
    @Operation(summary = "Find a specific book by your id")
    public Book findBook(@PathVariable ("id") Long id, @PathVariable("currency") String currency){
        var port = environment.getProperty("local.server.port");
        var book = bookRepository.getById(id);

        if (book == null) throw new RuntimeException("Book not found");

         var cambio = cambioProxy.getCambio(book.getPrince().doubleValue(),"USD",currency);

        book.setEnvironment("Book port: " + port + " Cambio port: " + cambio.getEnvironment());
        book.setPrince(cambio.getConvertedValue());

        return book;
    }
}
