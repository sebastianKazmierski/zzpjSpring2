package pl.spring.avocado.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.spring.avocado.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
