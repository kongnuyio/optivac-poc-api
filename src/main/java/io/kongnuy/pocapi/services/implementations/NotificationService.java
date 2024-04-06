package io.kongnuy.pocapi.services.implementations;

import org.springframework.stereotype.Service;

import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.AndroidConfig.Priority;

import io.kongnuy.pocapi.dtos.in.notification.NotificationIn;
import io.kongnuy.pocapi.services.interfaces.INotificationService;
import io.kongnuy.pocapi.services.interfaces.IUserService;
import lombok.extern.java.Log;

@Log
@Service("notificationService")
public class NotificationService implements INotificationService {

  private final FirebaseMessaging fcm;

  private final IUserService userService;
    
  public NotificationService(final FirebaseMessaging fcm, IUserService userService) {
    this.fcm = fcm;
    this.userService = userService;        
  }

  @Override
  public boolean send(NotificationIn notificationIn) {
    var user = userService.getOneByUuidOrExternalUuid(notificationIn.getUuidOrExternalUuid());
    if (user.getFcmToken() != null) {
      var msg = Message.builder()
          .setToken(user.getFcmToken())
          .setAndroidConfig(
            AndroidConfig
            .builder()
            .setPriority(Priority.HIGH)
            .setTtl(60 * 60 * 24)
            .build())
          .putData("click_action", "FLUTTER_NOTIFICATION_CLICK")
          .putData("type", notificationIn.getType())
          .putData("userId", notificationIn.getUuidOrExternalUuid())
          .putData("uuid", notificationIn.getUuidOrExternalUuid())
          .putData("title", notificationIn.getTitle())
          .putData("body", notificationIn.getBody())
          .build();

        try {
          String id = fcm.send(msg);
          log.info("==> Notification is sent " + id);
          return true;
        } catch (FirebaseMessagingException e) {
          e.printStackTrace();
        }
    }
    return false;
  }
  
}
