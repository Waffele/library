package chmielecki.a.library.services;

import chmielecki.a.library.domain.Book;
import chmielecki.a.library.repositories.BookRepository;
import chmielecki.a.library.repositories.PendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private final BookRepository bookRepository;
    @Autowired
    private final PendingRepository pendingRepository;

    public BookServiceImpl(BookRepository bookRepository, PendingRepository pendingRepository) {
        this.bookRepository = bookRepository;
        this.pendingRepository = pendingRepository;
    }

    @Override
    public Book saveUpdateBook(Book book) {
        if(Objects.isNull(book.getPending())){
            book.setPending(pendingRepository.findById((long) 2).get());
        }
        return  bookRepository.save(book);

    }

    @Override
    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }
}
