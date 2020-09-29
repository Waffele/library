package chmielecki.a.library.services;


import chmielecki.a.library.domain.Book;
import chmielecki.a.library.domain.Pending;
import chmielecki.a.library.repositories.BookRepository;
import chmielecki.a.library.repositories.PendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class PendingServiceImpl implements PendingService {
    @Autowired
    private final BookRepository bookRepository;
    @Autowired
    private final PendingRepository pendingRepository;

    public PendingServiceImpl(BookRepository bookRepository, PendingRepository pendingRepository) {
        this.bookRepository = bookRepository;
        this.pendingRepository = pendingRepository;
    }

    @Override
    public Pending saveUpdatePending(Pending pending) {
        if(Objects.isNull(pending.getBook()) || Objects.isNull(pending.getUser())){
            return null;
        }
        return  pendingRepository.save(pending);
    }

    @Override
    public Optional<Pending> findPendingById(Long id) {
        return pendingRepository.findById(id);
    }
}
