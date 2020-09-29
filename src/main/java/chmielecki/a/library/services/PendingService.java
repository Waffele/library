package chmielecki.a.library.services;

import chmielecki.a.library.domain.Book;
import chmielecki.a.library.domain.Pending;

import java.util.Optional;

public interface PendingService {

    public Pending saveUpdatePending(Pending pending);
    public Optional<Pending> findPendingById(Long id);
}
