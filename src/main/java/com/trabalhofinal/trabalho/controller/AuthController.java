package com.trabalhofinal.trabalho.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalhofinal.trabalho.dto.CredenciaisLoginDTO;
import com.trabalhofinal.trabalho.entity.User;
import com.trabalhofinal.trabalho.security.JWTUtil;
import com.trabalhofinal.trabalho.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/registro")
    public Map<String, Object> registerHandler(@RequestBody User user){
       
        String encodedPass = passwordEncoder.encode(user.getUserPassword());
        user.setUserPassword(encodedPass);

        user = userService.saveUser(user);
     
        User usuarioResumido = new User();
        usuarioResumido.setUsuarioNome(user.getUsuarioNome());
        usuarioResumido.setUserEmail(user.getUserEmail());
        usuarioResumido.setUserId(user.getUserId());
        String token = jwtUtil.generateTokenWithUserData(usuarioResumido);

        return Collections.singletonMap("jwt-token", token);
    }

    // Login de usuario
    @PostMapping("/login")
    public Map<String, Object> loginHandler
    	(@RequestBody CredenciaisLoginDTO credenciaisLoginDTO){
        try {
            // Criando o token que sera usado no processo de autenticacao
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(credenciaisLoginDTO.getEmail(), 
                    		credenciaisLoginDTO.getPassword());

            // Autenticando as credenciais de login
            authManager.authenticate(authInputToken);

            User user = userService.findByEmail(credenciaisLoginDTO.getEmail());
            User usuarioResumido = new User();
            usuarioResumido.setUsuarioNome(user.getUsuarioNome());
            usuarioResumido.setUserEmail(user.getUserEmail());
            usuarioResumido.setUserId(user.getUserId());
            // Gerando o token JWT a partir dos dados do Usuario
            String token = jwtUtil.generateTokenWithUserData(usuarioResumido);

            // Responde com o JWT
            return Collections.singletonMap("jwt-token", token);
        }catch (AuthenticationException authExc){
            throw new RuntimeException("Credenciais Invalidas");
        }
    }
}
