package com.ssysemployees.users.controler;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ssysemployees.core.config.security.TokenService;
import com.ssysemployees.users.domain.User;
import com.ssysemployees.users.dto.LoginDto;
import com.ssysemployees.users.dto.TokenDto;
import com.ssysemployees.users.service.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@SecurityRequirement(name = "bearer-key")
@RequestMapping("/api/users")
@RestController
public class UserController {
    
    private final UserService userService;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

   @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody @Valid LoginDto login, UriComponentsBuilder uriBuilder)
    throws Exception {
        try {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(login.email(), login.senha());
            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            var usuario = (User) authentication.getPrincipal();
            var tokenDTO = new TokenDto(tokenService.gerarToken(usuario));
            URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
            return ResponseEntity.created(uri).body(tokenDTO);
        } catch (Exception err) {
            return null;
        }
    }

}
