package Assignment1.repo;

import Assignment1.domain.Post;

import java.util.List;

public interface PostRepo {
    public List<Post> findAll();

    Post findById(long id);

    void save(Post p);

    void delete(long id);

    void update(long id, Post p);

    List<Post> findAllByAuthor(String author);
}
