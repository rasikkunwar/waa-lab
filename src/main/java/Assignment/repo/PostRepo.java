package Assignment.repo;

import Assignment.domain.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post, Long> {
//    List<Post> findAllByAuthor(String author);
}
