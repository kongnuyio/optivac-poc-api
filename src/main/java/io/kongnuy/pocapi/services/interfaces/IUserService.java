package io.kongnuy.pocapi.services.interfaces;

import java.util.List;
import io.kongnuy.pocapi.dtos.out.user.UserList;

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
   * @return La liste des comptes
   * 
   * @see https://google.com
   */
  public List<UserList> findAll(Integer limit, Integer page, String search);
}
