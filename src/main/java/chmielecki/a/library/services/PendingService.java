package chmielecki.a.library.services;

import chmielecki.a.library.domain.Borrow;
import chmielecki.a.library.domain.Pending;

import java.util.Optional;

public interface PendingService {

    public Pending saveUpdatePending(Borrow borrow);
    public Pending deletePending(Pending pending);
    public Optional<Pending> findPendingById(Long id);
}
