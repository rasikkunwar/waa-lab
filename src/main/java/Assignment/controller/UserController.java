package Assignment.controller;

import Assignment.domain.Post;
import Assignment.domain.User;
import Assignment.dto.PostDto;
import Assignment.dto.UserDto;
import Assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDto> findAll(){
        return  userService.findAll();
    }


    @GetMapping("{id}")
    public UserDto findById(@PathVariable long id){
        return userService.findById(id);
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

    @GetMapping("/having-more-than-one-posts")
    public List<UserDto> findAllUsersHavingMoreThanOnePosts(){
        return userService.findAllUsersHavingMoreThanOnePosts();
    }

}
