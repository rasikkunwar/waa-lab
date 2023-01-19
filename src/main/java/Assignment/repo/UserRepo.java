package Assignment.repo;

import Assignment.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User,Long> {
    @Query("SELECT u FROM User u join u.posts p group by u.id having count(p.id) > 1")
    List<User> findAllUsersHavingMoreThanOnePosts();
}
