package com.revature.pokebid.auth;

import com.revature.pokebid.auth.dtos.requests.LoginRequest;
import com.revature.pokebid.auth.dtos.responses.Principal;
import com.revature.pokebid.user.UserService;
import com.revature.pokebid.util.annotations.Inject;
import com.revature.pokebid.util.cutom_exceptions.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Inject
    private final UserService userService;
    private final TokenService tokenService;

    @Inject
    @Autowired
    public AuthController(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Principal login(@RequestBody LoginRequest request, HttpServletResponse resp) {
        if(request.getUsername() == null){
            throw new InvalidRequestException("Empty username entered.");
        }
        Principal principal = new Principal(userService.login(request));
        String token = tokenService.generateToken(principal);
        resp.setHeader("Authorization", token);
        return principal;
    }
}
