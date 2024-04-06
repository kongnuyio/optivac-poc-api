package io.kongnuy.pocapi.dtos.in.notification;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationIn {
  @NotNull
  @NotBlank
  protected String uuidOrExternalUuid;

  @NotNull
  @NotBlank
  protected String type;
  
  @NotNull
  @NotBlank
  protected String title;

  @NotNull
  @NotBlank
  protected String body;
}
