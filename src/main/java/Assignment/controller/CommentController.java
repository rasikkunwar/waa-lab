package Assignment.controller;

import Assignment.domain.Comment;
import Assignment.dto.CommentDto;
import Assignment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    public final CommentService commentService;

    @GetMapping
    public List<CommentDto> findAll(){
        return commentService.findAll();
    }

    @PostMapping
    public void save(@RequestBody Comment comment){
        commentService.save(comment);
    }

}
