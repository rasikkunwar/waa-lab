package Assignment.service;

import Assignment.domain.Post;
import Assignment.domain.User;
import Assignment.dto.CommentDto;
import Assignment.dto.PostDto;
import Assignment.dto.UserDto;

import java.util.List;

public interface UserService {

    public List<UserDto> findAll();

    UserDto findById(long id);


    void save(User u);

    void delete(long id);

    void update(User u);

    List<PostDto> findAllPostsByUser(long id);

    List<UserDto> findAllUsersHavingMoreThanNPosts(Integer nop);

    List<UserDto> findAllUsersHavingPostsWithTitle(String title);

    CommentDto findCommentByUserPostId(Long id, Long postId, Long commentId);
}
