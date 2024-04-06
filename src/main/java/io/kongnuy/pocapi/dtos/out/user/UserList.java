package io.kongnuy.pocapi.dtos.out.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserList {
  protected Long id;
  protected String uuid;
  protected String firstname;
  protected String lastname;
  protected String fcmToken;
  protected String externalUuid;
  protected String platform;
  protected boolean notifyMeOnNewBlogArticle;
  protected boolean notifyMeOnNewBonPlan;
  protected boolean notifyMeOnCarteProExpiration;
  protected boolean notifyMeOnNewRightArticle;
}
