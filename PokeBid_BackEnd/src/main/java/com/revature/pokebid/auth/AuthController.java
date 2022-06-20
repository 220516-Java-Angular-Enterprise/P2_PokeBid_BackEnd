package com.revature.pokebid.auth;

import com.revature.pokebid.auth.dtos.requests.LoginRequest;
import com.revature.pokebid.auth.dtos.responses.Principal;
import com.revature.pokebid.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Principal login(@ResponseBody LoginRequest request, HttpServletResponse resp) {
        Principal principal = new Principal(userService.login(request));
        String token = tokenService.generateToken(principal);
        resp.setHeader("Authorization", token);
        return principal;
    }

}
