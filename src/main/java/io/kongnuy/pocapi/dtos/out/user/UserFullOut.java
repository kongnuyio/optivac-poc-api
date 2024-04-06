package io.kongnuy.pocapi.dtos.out.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class UserFullOut extends UserStandardOut {
  protected Long id;
  protected String fcmToken;
}
