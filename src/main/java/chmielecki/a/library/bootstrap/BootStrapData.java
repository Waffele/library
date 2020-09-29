package chmielecki.a.library.bootstrap;

import chmielecki.a.library.domain.Book;
import chmielecki.a.library.domain.Pending;
import chmielecki.a.library.domain.User;
import chmielecki.a.library.repositories.BookRepository;
import chmielecki.a.library.repositories.PendingRepository;
import chmielecki.a.library.repositories.UserRepository;
import chmielecki.a.library.services.BookService;
import chmielecki.a.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final PendingRepository pendingRepository;
    private final UserRepository userRepository;

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    public BootStrapData(BookRepository bookRepository, PendingRepository pendingRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.pendingRepository = pendingRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User eric = new User("Eric");
        Book book = new Book("example","123");
        Pending pending = new Pending(0);

        bookRepository.save(book);
        pendingRepository.save(pending);
        userRepository.save(eric);

        eric.setPending(pending);
        pending.setUser(eric);
        pending.setBook(book);
        book.setPending(pending);

        bookRepository.save(book);
        pendingRepository.save(pending);
        userRepository.save(eric);


    }
}
