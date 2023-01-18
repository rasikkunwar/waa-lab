package Assignment1.controller;

import Assignment1.domain.Post;
import Assignment1.dto.PostDto;
import Assignment1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class ProductController {
    @Autowired
    PostService postService;

    @GetMapping
    public List<PostDto> findAll(@RequestParam(value="filter",required = false) String author){
        return author == null ? postService.findAll() :postService.findAllByAuthor(author) ;
    }


    @GetMapping("{id}")
    public PostDto findById(@PathVariable long id){
        return postService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Post post){
        postService.save(post);
    }

    @PutMapping("{id}")
    public void update(@PathVariable long id, @RequestBody Post post){
        postService.update(id,post);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id){
        postService.delete(id);
    }
}
