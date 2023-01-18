package Lab.lab.assignment.repo.impl;

import Lab.lab.assignment.domain.Post;
import Lab.lab.assignment.domain.PostV2;
import Lab.lab.assignment.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {
    private static List<Post> posts;
    private static int postId = 300;
    static {
        posts = new ArrayList<>();
        Post p1 = new Post(111,"Hello World","ASASAS","SSAS");
        Post p2 = new Post(112,"Lorem Ipsum","ASASASAS","ASAS");
        posts.add(p1);
        posts.add(p2);
    }

    public List<Post> findAll(){
        return posts;
    }

    @Override
    public void save(Post p) {
        p.setId(postId); // We are auto generating the id for DEMO purposes, (Normally, do not change your parameters)
        postId++;
        posts.add(p);
    }

    @Override
    public void delete(long id) {
        var post =posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst().get();
        posts.remove(post);
    }


    @Override
    public void update(long id, Post p) {
        Post toUpdate = findById(id);
        toUpdate.setTitle(p.getTitle());
        toUpdate.setContent(p.getContent());
        toUpdate.setAuthor(p.getAuthor());
    }
    public Post findById(long id) {
        return posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Post> findAllByAuthor(String author){
        return posts.stream().filter(l-> Objects.equals(l.getAuthor(), author)).collect(Collectors.toList());
    }
}
