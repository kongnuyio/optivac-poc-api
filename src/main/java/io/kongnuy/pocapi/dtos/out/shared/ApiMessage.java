package io.kongnuy.pocapi.dtos.out.shared;

import io.kongnuy.pocapi.constants.ApiMessageTypes;
import lombok.Data;

@Data
public class ApiMessage {
  private String code;
  private String message;
  private ApiMessageTypes type;
}
