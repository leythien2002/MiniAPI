package example.repository;

import example.entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface NewRepository extends JpaRepository<NewEntity, Long> {
}
