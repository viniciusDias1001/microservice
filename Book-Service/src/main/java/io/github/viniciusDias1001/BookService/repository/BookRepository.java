package io.github.viniciusDias1001.BookService.repository;

import io.github.viniciusDias1001.BookService.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
