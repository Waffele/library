package chmielecki.a.library.services;


import chmielecki.a.library.domain.Book;
import chmielecki.a.library.domain.Borrow;
import chmielecki.a.library.domain.Pending;
import chmielecki.a.library.domain.User;
import chmielecki.a.library.repositories.BookRepository;
import chmielecki.a.library.repositories.PendingRepository;
import chmielecki.a.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PendingServiceImpl implements PendingService {
    @Autowired
    private final BookRepository bookRepository;
    @Autowired
    private final PendingRepository pendingRepository;
    @Autowired
    private final UserRepository userRepository;

    public PendingServiceImpl(BookRepository bookRepository, PendingRepository pendingRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.pendingRepository = pendingRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Pending saveUpdatePending(Borrow borrow) {

        Optional<Book> book = bookRepository.findById((long) borrow.getB());
        Optional<User> user = userRepository.findById((long) borrow.getU());
        if(!book.isPresent() && !user.isPresent()){
            return null;
        }
        Pending pending = new Pending();
        pending.setBook(book.get());
        pending.setUser(user.get());
        pending.setDays(borrow.getD());

        book.get().setPending(pending);
        user.get().setPending(pending);

        pendingRepository.save(pending);
        bookRepository.save(book.get());
        userRepository.save(user.get());

        return  pendingRepository.save(pending);
    }

    @Override
    public Pending deletePending(Pending pending) {

        Optional<Pending> toDel = pendingRepository.findById(pending.getId());
        if(!toDel.isPresent()){
            return null;
        }

        toDel.get().getBook().setPending(null);
        toDel.get().getUser().setPending(null);

        pendingRepository.deleteById(toDel.get().getId());
        return null;
    }

    @Override
    public Optional<Pending> findPendingById(Long id) {
        return pendingRepository.findById(id);
    }
}
