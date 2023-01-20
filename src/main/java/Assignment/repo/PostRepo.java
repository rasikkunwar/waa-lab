package Assignment.repo;

import Assignment.domain.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepo extends CrudRepository<Post, Long> {
//    List<Post> findAllByAuthor(String author);

        List<Post> findAllByTitleIs(String title);

}
