package Assignment.service.impl;

import Assignment.dto.PostDto;
import Assignment.repo.PostRepo;
import Assignment.domain.Post;
import Assignment.helper.ListMapper;

import Assignment.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    public final PostRepo postRepo;
    public final ModelMapper modelMapper;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToDto;
    public List<PostDto> findAll() {
        List<Post> list = new ArrayList<>();
        postRepo.findAll().forEach(x->list.add((Post) x));
        return (List<PostDto>) listMapperPostToDto.mapList(list,new PostDto());}

    public List<PostDto> findAllByAuthor(String author) {
        return null;
//        return (List<PostDto>) listMapperPostToDto.mapList(postRepo.findAllByAuthor(author),new PostDto());
    }

    @Override
    public PostDto findById(long id) {
        return modelMapper.map(postRepo.findById(id),PostDto.class);
    }

    @Override
    public void save(Post p) {
        postRepo.save(p);
    }

    @Override
    public void delete(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void update(Post p) {
        postRepo.save(p);
    }
}
