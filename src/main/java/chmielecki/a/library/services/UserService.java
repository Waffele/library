package chmielecki.a.library.services;

import chmielecki.a.library.domain.Book;
import chmielecki.a.library.domain.User;

import java.util.Optional;

public interface UserService {

    public User saveUpdateUser(User user);
    public User deleteUser(User user);
    public Optional<User> findUserById(Long id);
}
