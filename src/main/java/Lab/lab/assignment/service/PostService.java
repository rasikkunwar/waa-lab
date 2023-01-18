package Lab.lab.assignment.service;
import Lab.lab.assignment.domain.Post;
import Lab.lab.assignment.dto.PostDto;

import java.util.List;

public interface PostService {
    public List<PostDto> findAll();



    PostDto findById(long id);

    void save(Post p);

    void delete(long id);

    void update(long id, Post p);

    List<PostDto> findAllByAuthor(String author);

}
