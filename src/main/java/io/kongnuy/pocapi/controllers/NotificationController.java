package io.kongnuy.pocapi.controllers;

import io.kongnuy.pocapi.constants.Constants;
import io.kongnuy.pocapi.dtos.in.notification.NotificationIn;
import io.kongnuy.pocapi.dtos.out.shared.GenericApiResponse;
import io.kongnuy.pocapi.services.interfaces.INotificationService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(Constants.API_NOTIFICATION_PREFIX)
@Tag(name = "Notifications")
public class NotificationController {
  
  private final INotificationService notificationService;

  public NotificationController(@Qualifier("notificationService") final INotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @PostMapping(path = "/send", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create the notification ", description = "Whether you are a LazzyConnect Admin or a Company,"
      + "this endpoint can help get the current registered notification within your organization.<br/> "
      + "When calling this API endpoint, you can fill in the following parameters : <br/><ul>"
      + "<li><b> limit : </b>The maximun number of elements you want to retrieve,<br/></li>"
      + "<li><b> page : </b>This represents the offset. From where do you want to start,<br/></li>"
      + "<li><b> search : </b>Filter the result by index (the index is a combination of the lastname, firstname and email).<br/></li></ul>", responses = {
          @ApiResponse(responseCode = "200", description = "Successful operation !!!", content = @Content(schema = @Schema(implementation = Boolean.class))),
          @ApiResponse(responseCode = "403", description = "Current notification is not allowed to call this endpoint.", content = @Content(schema = @Schema(implementation = GenericApiResponse.class), examples = {
              @ExampleObject(value = "{\n" + //
                  "  \"data\": null,\n" + //
                  "  \"status\": \"FAILED\",\n" + //
                  "  \"messages\": [\n" + //
                  "    {\n" + //
                  "      \"code\": \"string\",\n" + //
                  "      \"message\": \"string\",\n" + //
                  "      \"type\": \"ERROR\"\n" + //
                  "    }\n" + //
                  "  ]\n" + //
                  "}")
          })),
          @ApiResponse(responseCode = "500", description = "Something wrong happened. Please try again or contact our customer service.")
      })
  public GenericApiResponse<?> send(@Valid @RequestBody NotificationIn notificationIn) {
    return new GenericApiResponse<>(notificationService.send(notificationIn));
  }
}
