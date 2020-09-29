package chmielecki.a.library.services;

import chmielecki.a.library.domain.Book;
import chmielecki.a.library.domain.Pending;
import chmielecki.a.library.repositories.BookRepository;
import chmielecki.a.library.repositories.PendingRepository;
import chmielecki.a.library.repositories.UserRepository;
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
    @Autowired
    private final UserRepository userRepository;

    public BookServiceImpl(BookRepository bookRepository, PendingRepository pendingRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.pendingRepository = pendingRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Book saveUpdateBook(Book book) {


        return  bookRepository.save(book);

    }

    @Override
    public Book deleteBook(Book book) {

        Optional<Book> toDel = bookRepository.findById(book.getId());
        if(!toDel.isPresent()){
            return null;
        }

        if(!Objects.isNull(toDel.get().getPending())){
            Optional<Pending> pending = pendingRepository.findById(toDel.get().getPending().getId());
            pending.get().getUser().setPending(null);
            toDel.get().setPending(null);
            pending.get().setBook(null);
            pending.get().setUser(null);

            pendingRepository.deleteById(pending.get().getId());
        }

        bookRepository.deleteById(toDel.get().getId());
        return null;
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }
}
