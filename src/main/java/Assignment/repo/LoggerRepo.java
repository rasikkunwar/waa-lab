package Assignment.repo;

import Assignment.domain.Logger;
import org.springframework.data.repository.CrudRepository;

public interface LoggerRepo extends CrudRepository<Logger, Long> {
}
