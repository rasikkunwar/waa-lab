package Assignment.repo;

import Assignment.domain.Comment;
import Assignment.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User,Long> {

    User findByEmail(String email);

    @Query("SELECT u FROM User u join u.posts p group by u.id having count(p.id) > :nop")
    List<User> findAllUsersHavingMoreThanNPosts(Integer nop);

    @Query("SELECT u FROM User u join u.posts p where p.title = :title")
    List<User> findAllUsersHavingPostsWithTitle(String title);

    @Query("SELECT c FROM Comment c join c.post p join p.user u where u.id = :id and p.id = :postId and c.id = :commentId")
    Comment findCommentOfPostByUserId(Long id,Long postId, Long commentId);
}
