package io.kongnuy.pocapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kongnuy.pocapi.constants.Constants;
import io.kongnuy.pocapi.dtos.out.shared.GenericApiResponse;
import io.kongnuy.pocapi.dtos.out.user.UserList;
import io.kongnuy.pocapi.services.interfaces.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;

@RestController
@RequestMapping(Constants.API_USER_PREFIX)
@Tag(name = "Users")
public class UserController {

  @Resource(name = "userService")
  IUserService userService;

  @GetMapping(path = "", produces = "application/json; charset=UTF-8")
  @Operation(summary = "Get the list of users that the current user can access/manage.", description = "Whether you are a LazzyConnect Admin or a Company,"
      + "this endpoint can help get the current registered user within your organization.<br/> "
      + "When calling this API endpoint, you can fill in the following parameters : <br/><ul>"
      + "<li><b> limit : </b>The maximun number of elements you want to retrieve,<br/></li>"
      + "<li><b> page : </b>This represents the offset. From where do you want to start,<br/></li>"
      + "<li><b> search : </b>Filter the result by index (the index is a combination of the lastname, firstname and email).<br/></li></ul>", responses = {
          @ApiResponse(responseCode = "200", description = "Successful operation !!!", content = @Content(schema = @Schema(implementation = UserList.class))),
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
  public ResponseEntity<?> findAll(
      @RequestParam(required = false) Integer limit,
      @RequestParam(required = false) Integer page,
      @RequestParam(required = false) String search) {
    return ResponseEntity.ok(new GenericApiResponse<>(userService.findAll(limit, page, search)));
  }
}