package io.kongnuy.pocapi.mappers;

import java.util.List;

import org.mapstruct.AnnotateWith;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.AnnotateWith.Element;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Service;

import io.kongnuy.pocapi.dtos.in.user.UserCreateIn;
import io.kongnuy.pocapi.dtos.in.user.UserUpdateIn;
import io.kongnuy.pocapi.dtos.out.user.UserFullOut;
import io.kongnuy.pocapi.dtos.out.user.UserStandardOut;
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
  
  UserStandardOut toUserStandardOut(User user);

  UserFullOut toUserFullOut(User user);

  void fromUserUpdateIn(UserUpdateIn userUpdateIn, @MappingTarget User user);

  @Mapping(target="uuid", source="uuid", defaultExpression = "java(java.util.UUID.randomUUID().toString())")
  User fromUserCreateIn(UserCreateIn userCreateIn);

  List<UserStandardOut> toUserStandardOut(List<User> user);
}
