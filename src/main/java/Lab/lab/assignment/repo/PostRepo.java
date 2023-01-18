package Lab.lab.assignment.repo;

import Lab.lab.assignment.domain.Post;
import Lab.lab.assignment.domain.PostV2;

import java.util.List;

public interface PostRepo {
    public List<Post> findAll();

    Post findById(long id);

    void save(Post p);

    void delete(long id);

    void update(long id, Post p);

    List<Post> findAllByAuthor(String author);
}
