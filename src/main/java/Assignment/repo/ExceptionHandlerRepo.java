package Assignment.repo;

import Assignment.domain.ExceptionHandler;
import Assignment.domain.Logger;
import org.springframework.data.repository.CrudRepository;

public interface ExceptionHandlerRepo extends CrudRepository<ExceptionHandler, Long> {
}
