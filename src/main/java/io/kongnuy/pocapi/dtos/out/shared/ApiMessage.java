package io.kongnuy.pocapi.dtos.out.shared;

import io.kongnuy.pocapi.constants.ApiMessageTypes;
import lombok.Data;

@Data
public class ApiMessage {
  protected String code;
  protected String message;
  protected ApiMessageTypes type;
}
