package Assignment1.service.impl;

import Assignment1.dto.PostDto;
import Assignment1.repo.PostRepo;
import Assignment1.domain.Post;
import Assignment1.helper.ListMapper;

import Assignment1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    public final PostRepo postRepo;
    public final ModelMapper modelMapper;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToDto;
    public List<PostDto> findAll() {
        return (List<PostDto>) listMapperPostToDto.mapList(postRepo.findAll(),new PostDto());}

    public List<PostDto> findAllByAuthor(String author) {
        return (List<PostDto>) listMapperPostToDto.mapList(postRepo.findAllByAuthor(author),new PostDto());}

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
        postRepo.delete(id);
    }

    @Override
    public void update(long id, Post p) {
        postRepo.update(id, p);
    }
}
