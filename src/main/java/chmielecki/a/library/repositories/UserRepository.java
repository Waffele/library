package chmielecki.a.library.repositories;


import chmielecki.a.library.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
