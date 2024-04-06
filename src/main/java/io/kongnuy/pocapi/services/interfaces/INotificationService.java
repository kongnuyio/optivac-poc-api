package io.kongnuy.pocapi.services.interfaces;

import io.kongnuy.pocapi.dtos.in.notification.NotificationIn;
/**
 * Classe de gestion des comptes utilisateurs
 * 
 * @author Victorien KONGNUY <kongnuyvictorien@gmail.com>
 * @version 1.0.0
 * @see https://google.com
 * 
 */
public interface INotificationService {

   /**
   * create the user with the provided uuid or external uuid.
   * 
   * @param notificationIn the unique identifier or the external uuid
   * 
   * @return boolean
   * 
   * @see https://google.com
   */
  public boolean send(NotificationIn notificationIn);

}
