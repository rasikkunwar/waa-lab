package Assignment.service.impl;

import Assignment.domain.Comment;
import Assignment.domain.Post;
import Assignment.dto.CommentDto;
import Assignment.helper.ListMapper;
import Assignment.repo.CommentRepo;
import Assignment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    public final CommentRepo commentRepo;
    public final ModelMapper modelMapper;

    @Autowired
    ListMapper<Comment, CommentDto> listMapperCommentToDto;
    public List<CommentDto> findAll() {
        List<Comment> list = new ArrayList<>();
        commentRepo.findAll().forEach(x->list.add((Comment) x));
        return (List<CommentDto>) listMapperCommentToDto.mapList(list,new CommentDto());}


    @Override
    public CommentDto findById(long id) {
        return modelMapper.map(commentRepo.findById(id),CommentDto.class);
    }

    @Override
    public void save(Comment p) {
        commentRepo.save(p);
    }

    @Override
    public void delete(long id) {
        commentRepo.deleteById(id);
    }

    @Override
    public void update(Comment p) {
        commentRepo.save(p);
    }
}
