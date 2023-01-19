package Assignment.service;
import Assignment.domain.Post;
import Assignment.dto.PostDto;

import java.util.List;

public interface PostService {
    public List<PostDto> findAll();



    PostDto findById(long id);

    void save(Post p);

    void delete(long id);

    void update(Post p);

    List<PostDto> findAllByAuthor(String author);

}
