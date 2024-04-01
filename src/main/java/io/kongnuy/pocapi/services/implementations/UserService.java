package io.kongnuy.pocapi.services.implementations;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import io.kongnuy.pocapi.dtos.out.user.UserList;
import io.kongnuy.pocapi.services.interfaces.IUserService;

@Service("userService")
public class UserService implements IUserService {

  @Override
  public List<UserList> findAll(Integer limit, Integer page, String search) {
    return Arrays.asList(new UserList(1l, "09597fed-58c0-4a98-86d8-84c69ae8737a"));
  }

}
