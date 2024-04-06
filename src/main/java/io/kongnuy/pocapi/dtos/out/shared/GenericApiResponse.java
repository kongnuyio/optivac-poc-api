package io.kongnuy.pocapi.dtos.out.shared;

import java.util.ArrayList;
import java.util.List;

import io.kongnuy.pocapi.constants.ApiResponseStatus;
import lombok.Data;

@Data
public class GenericApiResponse<T> {
  protected T data;
  protected ApiResponseStatus status;
  protected List<ApiMessage> messages;

  public GenericApiResponse(T data) {
    this.data = data;
    this.status = ApiResponseStatus.SUCCESS;
    this.messages = new ArrayList<>();
  }
}
