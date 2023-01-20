package Assignment.service;

import Assignment.domain.Comment;
import Assignment.dto.CommentDto;

import java.util.List;

public interface CommentService {
     List<CommentDto> findAll();

    CommentDto findById(long id);

    void save(Comment p);

    void delete(long id);

    void update(Comment p);
}
