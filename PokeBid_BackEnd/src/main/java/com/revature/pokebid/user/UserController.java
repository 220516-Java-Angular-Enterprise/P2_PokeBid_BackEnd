package com.revature.pokebid.user;

import com.revature.pokebid.condition.Condition;
import com.revature.pokebid.user.dtos.requests.ChangeAddressRequest;
import com.revature.pokebid.user.dtos.requests.ChangeEmailRequest;
import com.revature.pokebid.user.dtos.requests.ChangePasswordRequest;
import com.revature.pokebid.user.dtos.requests.NewUserRequest;
import com.revature.pokebid.util.annotations.Inject;
import com.revature.pokebid.util.cutom_exceptions.InvalidRequestException;
import com.revature.pokebid.util.cutom_exceptions.ResourceConflictException;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Inject
    private final UserService userService;

    @Inject
    @Autowired
    public UserController(UserService userService){ this.userService = userService; }

    @GetMapping
    public @ResponseBody List<User> getAllUsers(){ return userService.getAllUsers(); }

    @CrossOrigin
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Optional<User> getByUserId(@PathVariable String id) {
        return userService.getByUserId(id);
    }

    @CrossOrigin
    @GetMapping(value = "/get-by-email/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Optional<User> getUserByEmail(@PathVariable String email) { return userService.getUserByEmail(email); }

    @RequestMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String register(@RequestBody NewUserRequest request){
        return userService.register(request).getId();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(value = "/changePassword", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String changePassword(@RequestBody ChangePasswordRequest request){
         userService.updatePassword(request);
         return request.getPassword();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(value = "/changeEmail", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String changeEmail(@RequestBody ChangeEmailRequest request){
        userService.updateEmailById(request.getId(), request);
        return request.getEmail();
    }

    @RequestMapping("/changeAddress")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String changeEmail(@RequestBody ChangeAddressRequest request){
        userService.updateAddressById(request.getId(), request);
        return request.getAddress();
    }

    @ExceptionHandler
        @ResponseStatus(HttpStatus.CONFLICT)
        public @ResponseBody Map<String, Object> handleResourceConflictException(ResourceConflictException e){
        Map<String, Object> responseBody = new LinkedHashMap<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy HH:Mmm");

        responseBody.put("Status:", 409);
        responseBody.put("Message", e.getMessage());
        responseBody.put("Timestamp:", dtf.format(LocalDateTime.now()));
        return responseBody;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody Map<String, Object> handleBadRequestException(InvalidRequestException e){
        Map<String, Object> responseBody = new LinkedHashMap<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy HH:Mmm");

        responseBody.put("Status:", 409);
        responseBody.put("Message", e.getStackTrace());
        responseBody.put("Timestamp:", dtf.format(LocalDateTime.now()));
        return responseBody;
    }
}
