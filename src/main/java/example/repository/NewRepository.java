package example.repository;

import example.entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface NewRepository extends JpaRepository<NewEntity, Long> {

}
