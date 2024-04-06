package io.kongnuy.pocapi.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.kongnuy.pocapi.dtos.out.user.UserList;
import io.kongnuy.pocapi.mappers.IUserMapper;
import io.kongnuy.pocapi.repositories.IUserRepository;
import io.kongnuy.pocapi.services.interfaces.IUserService;

@Service("userService")
public class UserService implements IUserService {

  private final IUserRepository userRepository;

  private final IUserMapper userMapper;
  
  public UserService(@Qualifier("userRepository") final IUserRepository userRepository, @Qualifier("userMapper") final IUserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  @Override
  public List<UserList> findAll(Integer limit, Integer page, String search) {
    return userMapper.toUserList(userRepository.findAll());
  }
}
