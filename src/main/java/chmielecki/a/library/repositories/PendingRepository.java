package chmielecki.a.library.repositories;


import chmielecki.a.library.domain.Pending;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PendingRepository extends CrudRepository <Pending,Long> {
}
