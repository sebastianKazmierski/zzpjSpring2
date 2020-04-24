package pl.spring.avocado.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.spring.avocado.models.UnitOfMeasure;

@Repository
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure,Long> {
}
