package chmielecki.a.library.services;

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
        if(Objects.isNull(user.getPending())){
            user.setPending(pendingRepository.findById((long) 2).get());
        }
        return  userRepository.save(user);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }
}
