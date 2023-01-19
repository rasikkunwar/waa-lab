package Assignment.service.impl;

import Assignment.domain.Post;
import Assignment.domain.User;
import Assignment.dto.PostDto;
import Assignment.dto.UserDto;
import Assignment.helper.ListMapper;
import Assignment.repo.UserRepo;
import Assignment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    public final UserRepo userRepo;
    public final ModelMapper modelMapper;
    @Autowired
    ListMapper<User, UserDto> listMapperUserToDto;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToDto;

    @Override
    public List<UserDto> findAll() {
        List<User> list = new ArrayList<>();
        userRepo.findAll().forEach(x->list.add((User) x));
        return (List<UserDto>) listMapperUserToDto.mapList(list,new UserDto());    }

    @Override
    public UserDto findById(long id) {
        return modelMapper.map(userRepo.findById(id), UserDto.class);
    }

    @Override
    public void save(User u) {
        userRepo.save(u);
    }

    @Override
    public void delete(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void update(User u) {
         userRepo.save(u);
    }

    @Override
    public List<PostDto> findAllPostsByUser(long id) {
        return (List<PostDto>) listMapperPostToDto.mapList(userRepo.findById(id).get().getPosts(),new PostDto());
    }

    @Override
    public List<UserDto> findAllUsersHavingMoreThanOnePosts() {
        return (List<UserDto>) listMapperUserToDto.mapList(userRepo.findAllUsersHavingMoreThanOnePosts(),new UserDto());
    }

}
