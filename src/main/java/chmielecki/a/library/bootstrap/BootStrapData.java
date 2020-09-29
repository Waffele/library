package chmielecki.a.library.bootstrap;


import chmielecki.a.library.repositories.BookRepository;
import chmielecki.a.library.repositories.PendingRepository;
import chmielecki.a.library.repositories.UserRepository;
import chmielecki.a.library.services.BookService;
import chmielecki.a.library.services.PendingService;
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
    @Autowired
    private PendingService pendingService;

    public BootStrapData(BookRepository bookRepository, PendingRepository pendingRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.pendingRepository = pendingRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {




    }
}
