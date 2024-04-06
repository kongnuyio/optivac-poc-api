package io.kongnuy.pocapi.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kongnuy.pocapi.constants.Constants;
import io.kongnuy.pocapi.dtos.in.user.UserCreateIn;
import io.kongnuy.pocapi.dtos.in.user.UserUpdateIn;
import io.kongnuy.pocapi.dtos.out.shared.GenericApiResponse;
import io.kongnuy.pocapi.dtos.out.user.UserStandardOut;
import io.kongnuy.pocapi.services.interfaces.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(Constants.API_USER_PREFIX)
@Tag(name = "Users")
public class UserController {

  private final IUserService userService;

  public UserController(@Qualifier("userService") final IUserService userService) {
    this.userService = userService;
  }

  @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get the list of users that the current user can access/manage.", description = "Whether you are a LazzyConnect Admin or a Company,"
      + "this endpoint can help get the current registered user within your organization.<br/> "
      + "When calling this API endpoint, you can fill in the following parameters : <br/><ul>"
      + "<li><b> limit : </b>The maximun number of elements you want to retrieve,<br/></li>"
      + "<li><b> page : </b>This represents the offset. From where do you want to start,<br/></li>"
      + "<li><b> search : </b>Filter the result by index (the index is a combination of the lastname, firstname and email).<br/></li></ul>", responses = {
          @ApiResponse(responseCode = "200", description = "Successful operation !!!", content = @Content(schema = @Schema(implementation = UserStandardOut.class))),
          @ApiResponse(responseCode = "403", description = "Current user is not allowed to call this endpoint.", content = @Content(schema = @Schema(implementation = GenericApiResponse.class), examples = {
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
  public GenericApiResponse<?> findAll(
      @RequestParam(required = false) Integer limit,
      @RequestParam(required = false) Integer page,
      @RequestParam(required = false) String search) {
    return new GenericApiResponse<>(userService.findAll(limit, page, search));
  }


  @GetMapping(path = "/{uuid_or_external_uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get the user by uuid or external uuid.", description = "Whether you are a LazzyConnect Admin or a Company,"
      + "this endpoint can help get the current registered user within your organization.<br/> "
      + "When calling this API endpoint, you can fill in the following parameters : <br/><ul>"
      + "<li><b> limit : </b>The maximun number of elements you want to retrieve,<br/></li>"
      + "<li><b> page : </b>This represents the offset. From where do you want to start,<br/></li>"
      + "<li><b> search : </b>Filter the result by index (the index is a combination of the lastname, firstname and email).<br/></li></ul>", responses = {
          @ApiResponse(responseCode = "200", description = "Successful operation !!!", content = @Content(schema = @Schema(implementation = UserStandardOut.class))),
          @ApiResponse(responseCode = "403", description = "Current user is not allowed to call this endpoint.", content = @Content(schema = @Schema(implementation = GenericApiResponse.class), examples = {
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
  public GenericApiResponse<?> findOne(@PathVariable(name = "uuid_or_external_uuid") String uuidOrExternalUuid) {
    return new GenericApiResponse<>(userService.findOneByUuidOrExternalUuid(uuidOrExternalUuid));
  }

  @DeleteMapping(path = "/{uuid_or_external_uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Delete the user by uuid or external uuid.", description = "Whether you are a LazzyConnect Admin or a Company,"
      + "this endpoint can help get the current registered user within your organization.<br/> "
      + "When calling this API endpoint, you can fill in the following parameters : <br/><ul>"
      + "<li><b> limit : </b>The maximun number of elements you want to retrieve,<br/></li>"
      + "<li><b> page : </b>This represents the offset. From where do you want to start,<br/></li>"
      + "<li><b> search : </b>Filter the result by index (the index is a combination of the lastname, firstname and email).<br/></li></ul>", responses = {
          @ApiResponse(responseCode = "200", description = "Successful operation !!!", content = @Content(schema = @Schema(implementation = UserStandardOut.class))),
          @ApiResponse(responseCode = "403", description = "Current user is not allowed to call this endpoint.", content = @Content(schema = @Schema(implementation = GenericApiResponse.class), examples = {
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
  public GenericApiResponse<?> remove(@PathVariable(name = "uuid_or_external_uuid") String uuidOrExternalUuid) {
    return new GenericApiResponse<>(userService.removeOneByUuidOrExternalUuid(uuidOrExternalUuid));
  }

  @PutMapping(path = "/{uuid_or_external_uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Replace the user by uuid or external uuid.", description = "Whether you are a LazzyConnect Admin or a Company,"
      + "this endpoint can help get the current registered user within your organization.<br/> "
      + "When calling this API endpoint, you can fill in the following parameters : <br/><ul>"
      + "<li><b> limit : </b>The maximun number of elements you want to retrieve,<br/></li>"
      + "<li><b> page : </b>This represents the offset. From where do you want to start,<br/></li>"
      + "<li><b> search : </b>Filter the result by index (the index is a combination of the lastname, firstname and email).<br/></li></ul>", responses = {
          @ApiResponse(responseCode = "200", description = "Successful operation !!!", content = @Content(schema = @Schema(implementation = UserStandardOut.class))),
          @ApiResponse(responseCode = "403", description = "Current user is not allowed to call this endpoint.", content = @Content(schema = @Schema(implementation = GenericApiResponse.class), examples = {
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
  public GenericApiResponse<?> replace(@PathVariable(name = "uuid_or_external_uuid") String uuidOrExternalUuid, @Valid @RequestBody UserUpdateIn userUpdateIn) {
    return new GenericApiResponse<>(userService.updateOneByUuidOrExternalUuid(uuidOrExternalUuid, userUpdateIn));
  }


  @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create the user ", description = "Whether you are a LazzyConnect Admin or a Company,"
      + "this endpoint can help get the current registered user within your organization.<br/> "
      + "When calling this API endpoint, you can fill in the following parameters : <br/><ul>"
      + "<li><b> limit : </b>The maximun number of elements you want to retrieve,<br/></li>"
      + "<li><b> page : </b>This represents the offset. From where do you want to start,<br/></li>"
      + "<li><b> search : </b>Filter the result by index (the index is a combination of the lastname, firstname and email).<br/></li></ul>", responses = {
          @ApiResponse(responseCode = "200", description = "Successful operation !!!", content = @Content(schema = @Schema(implementation = UserStandardOut.class))),
          @ApiResponse(responseCode = "403", description = "Current user is not allowed to call this endpoint.", content = @Content(schema = @Schema(implementation = GenericApiResponse.class), examples = {
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
  public GenericApiResponse<?> create(@Valid @RequestBody UserCreateIn userUpdateIn) {
    return new GenericApiResponse<>(userService.create(userUpdateIn));
  }
}