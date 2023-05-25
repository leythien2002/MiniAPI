package example.repository;

import example.entity.CategoryEntity;
import example.entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findOneByCode(String code);
    //find one la lay single/ findBy la lay mot list

}
