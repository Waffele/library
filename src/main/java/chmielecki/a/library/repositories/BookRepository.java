package chmielecki.a.library.repositories;

import chmielecki.a.library.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {


}
