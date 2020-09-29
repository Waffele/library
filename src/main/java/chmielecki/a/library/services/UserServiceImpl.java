package chmielecki.a.library.services;

import chmielecki.a.library.domain.Book;
import chmielecki.a.library.domain.Pending;
import chmielecki.a.library.domain.User;
import chmielecki.a.library.repositories.BookRepository;
import chmielecki.a.library.repositories.PendingRepository;
import chmielecki.a.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PendingRepository pendingRepository;

    public UserServiceImpl(UserRepository userRepository, PendingRepository pendingRepository) {
        this.userRepository = userRepository;
        this.pendingRepository = pendingRepository;
    }

    @Override
    public User saveUpdateUser(User user) {

        return  userRepository.save(user);
    }

    @Override
    public User deleteUser(User user) {

        Optional<User> toDel = userRepository.findById(user.getId());
        if(!toDel.isPresent()){
            return null;
        }

        if(!Objects.isNull(toDel.get().getPending())){
            Optional<Pending> pending = pendingRepository.findById(toDel.get().getPending().getId());
            pending.get().getBook().setPending(null);
            toDel.get().setPending(null);
            pending.get().setBook(null);
            pending.get().setUser(null);
            pendingRepository.deleteById(pending.get().getId());
        }



        userRepository.deleteById(toDel.get().getId());
        return null;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }
}
