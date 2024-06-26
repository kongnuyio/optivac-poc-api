package io.kongnuy.pocapi.services.interfaces;

import java.util.List;

import io.kongnuy.pocapi.dtos.in.user.UserCreateIn;
import io.kongnuy.pocapi.dtos.in.user.UserUpdateIn;
import io.kongnuy.pocapi.dtos.out.user.UserFullOut;
import io.kongnuy.pocapi.dtos.out.user.UserStandardOut;
import io.kongnuy.pocapi.entities.User;

/**
 * Classe de gestion des comptes utilisateurs
 * 
 * @author Victorien KONGNUY <kongnuyvictorien@gmail.com>
 * @version 1.0.0
 * @see https://google.com
 * 
 */
public interface IUserService {

  /**
   * find the user with the provided parameters.
   * 
   * @param limit  The maximun number of elements you want to retrieve
   * @param page   This represents the offset. From where do you want to start
   * @param search Filter the result by index (the index is a combination of the
   *               lastname, firstname and email).
   * 
   * @return the list of users
   * 
   * @see https://google.com
   */
  public List<UserStandardOut> findAll(Integer limit, Integer page, String search);

  /**
   * find the user with the provided uuid or external uuid.
   * 
   * @param uuidOrExternalUuid the unique identifier or the external uuid
   * 
   * @return the user
   * 
   * @see https://google.com
   */
  public UserFullOut findOneByUuidOrExternalUuid(String uuidOrExternalUuid);

  /**
   * get the user with the provided uuid or external uuid.
   * 
   * @param uuidOrExternalUuid the unique identifier or the external uuid
   * 
   * @return the user
   * 
   * @see https://google.com
   */
  public User getOneByUuidOrExternalUuid(String uuidOrExternalUuid);

  /**
   * find the user with the provided uuid or external uuid.
   * 
   * @param uuidOrExternalUuid the unique identifier or the external uuid
   * 
   * @return the user
   * 
   * @see https://google.com
   */
  public boolean removeOneByUuidOrExternalUuid(String uuidOrExternalUuid);

   /**
   * get the user with the provided uuid or external uuid.
   * 
   * @param uuidOrExternalUuid the unique identifier or the external uuid
   * 
   * @return the user
   * 
   * @see https://google.com
   */
  public UserFullOut updateOneByUuidOrExternalUuid(String uuidOrExternalUuid, UserUpdateIn userUpdateIn);

   /**
   * create the user with the provided uuid or external uuid.
   * 
   * @param uuidOrExternalUuid the unique identifier or the external uuid
   * 
   * @return the user
   * 
   * @see https://google.com
   */
  public UserFullOut create(UserCreateIn userCreateIn);

}
