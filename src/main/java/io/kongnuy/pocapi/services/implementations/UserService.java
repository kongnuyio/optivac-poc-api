package io.kongnuy.pocapi.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.kongnuy.pocapi.dtos.in.user.UserCreateIn;
import io.kongnuy.pocapi.dtos.in.user.UserUpdateIn;
import io.kongnuy.pocapi.dtos.out.user.UserFullOut;
import io.kongnuy.pocapi.dtos.out.user.UserStandardOut;
import io.kongnuy.pocapi.entities.User;
import io.kongnuy.pocapi.mappers.IUserMapper;
import io.kongnuy.pocapi.repositories.IUserRepository;
import io.kongnuy.pocapi.services.interfaces.IUserService;
import jakarta.persistence.EntityNotFoundException;

@Service("userService")
public class UserService implements IUserService {

  private final IUserRepository userRepository;

  private final IUserMapper userMapper;
  
  public UserService(@Qualifier("userRepository") final IUserRepository userRepository, @Qualifier("userMapper") final IUserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  @Override
  public List<UserStandardOut> findAll(Integer limit, Integer page, String search) {
    return userMapper.toUserStandardOut(userRepository.findAll());
  }

  @Override
  public UserFullOut findOneByUuidOrExternalUuid(String uuidOrExternalUuid) {
    return userMapper.toUserFullOut(this.getOneByUuidOrExternalUuid(uuidOrExternalUuid));
  }

  @Override
  public User getOneByUuidOrExternalUuid(String uuidOrExternalUuid) {
    var user = userRepository.findByUuidOrExternalUuid(uuidOrExternalUuid, uuidOrExternalUuid);
    if (user.isEmpty()) {
      throw new EntityNotFoundException();
    }

    return user.get();
  }

  @Override
  public boolean removeOneByUuidOrExternalUuid(String uuidOrExternalUuid) {
    var user = this.getOneByUuidOrExternalUuid(uuidOrExternalUuid);
    userRepository.delete(user);
    return true;
  }

  @Override
  public UserFullOut updateOneByUuidOrExternalUuid(String uuidOrExternalUuid, UserUpdateIn userUpdateIn) {
    var user = this.getOneByUuidOrExternalUuid(uuidOrExternalUuid);
    userMapper.fromUserUpdateIn(userUpdateIn, user);
    userRepository.save(user);
    return userMapper.toUserFullOut(user);
  }

  @Override
  public UserFullOut create(UserCreateIn userCreateIn) {
    var user = userMapper.fromUserCreateIn(userCreateIn);
    userRepository.save(user);
    return userMapper.toUserFullOut(user);
  }

}
