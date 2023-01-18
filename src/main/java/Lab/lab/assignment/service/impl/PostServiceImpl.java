package Lab.lab.assignment.service.impl;

import Lab.lab.assignment.domain.Post;
import Lab.lab.assignment.domain.PostV2;
import Lab.lab.assignment.dto.PostDto;
import Lab.lab.assignment.helper.ListMapper;
import Lab.lab.assignment.repo.PostRepo;

import Lab.lab.assignment.service.PostService;
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
