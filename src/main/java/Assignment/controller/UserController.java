package Assignment.controller;

import Assignment.aspect.annotation.ExecutionTime;
import Assignment.domain.Post;
import Assignment.domain.User;
import Assignment.dto.CommentDto;
import Assignment.dto.PostDto;
import Assignment.dto.UserDto;
import Assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDto> findAll(@RequestParam(name = "postTitle", required = false) String postTitle){
        return  postTitle == null ? userService.findAll() : userService.findAllUsersHavingPostsWithTitle(postTitle);
    }


    @ExecutionTime
    @GetMapping("{id}")
    public UserDto findById(@PathVariable long id){
        return userService.findById(id);
    }

    @GetMapping("{id}/posts/{postId}/comments/{commentId}")
    public CommentDto findById(@PathVariable Long id,@PathVariable Long postId , @PathVariable Long commentId){
        return userService.findCommentByUserPostId(id,postId,commentId);
    }

    @PostMapping
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @PutMapping
    public void update(@RequestBody User user){
        userService.update(user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id){
        userService.delete(id);
    }

    @GetMapping("{id}/posts")
    public List<PostDto> findAllPostsByUser(@PathVariable long id){
        return userService.findAllPostsByUser(id);
    }

    @GetMapping("/having-more-than-n-posts")
    public List<UserDto> findAllUsersHavingMoreThanNPosts(@RequestParam(value="filter") Integer nop){
        return userService.findAllUsersHavingMoreThanNPosts(nop);
    }

    @PostMapping("/check-exception")
    public void checkException(@RequestParam Integer age) {
        if(age<18) {
            //throw Arithmetic exception if not eligible to vote
            throw new ArithmeticException("Person is not eligible to vote");
        }
        else {
            System.out.println("Person is eligible to vote!!");
        }
    }

}
