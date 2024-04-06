package io.kongnuy.pocapi.mappers;

import java.util.List;

import org.mapstruct.AnnotateWith;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.AnnotateWith.Element;
import org.mapstruct.Mapper;

import org.springframework.stereotype.Service;

import io.kongnuy.pocapi.dtos.out.user.UserList;
import io.kongnuy.pocapi.entities.User;

@Mapper(
  implementationName = "UserMapperImpl", 
  componentModel="spring", 
  injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
@AnnotateWith(
  value = Service.class, 
  elements = @Element(strings = "userMapper")
)
public interface IUserMapper {
  
  UserList toUserList(User user);

  List<UserList> toUserList(List<User> user);
}
