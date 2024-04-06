package io.kongnuy.pocapi.dtos.in.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateIn {
  protected String uuid;
  protected String fcmToken;
  protected String firstname;
  protected String lastname;
  protected String externalUuid;
  protected String platform;
  protected boolean notifyMeOnNewBlogArticle;
  protected boolean notifyMeOnNewBonPlan;
  protected boolean notifyMeOnCarteProExpiration;
  protected boolean notifyMeOnNewRightArticle;
}
