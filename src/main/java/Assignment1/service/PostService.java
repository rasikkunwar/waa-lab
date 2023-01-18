package Assignment1.service;
import Assignment1.domain.Post;
import Assignment1.dto.PostDto;

import java.util.List;

public interface PostService {
    public List<PostDto> findAll();



    PostDto findById(long id);

    void save(Post p);

    void delete(long id);

    void update(long id, Post p);

    List<PostDto> findAllByAuthor(String author);

}
