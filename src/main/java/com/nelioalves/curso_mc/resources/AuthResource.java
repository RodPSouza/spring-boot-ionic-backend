package com.nelioalves.curso_mc.resources;

import com.nelioalves.curso_mc.security.JWTUtil;
import com.nelioalves.curso_mc.security.UserSS;
import com.nelioalves.curso_mc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
    public ResponseEntity<Void> refreshToken(HttpServletResponse response){
        UserSS user = UserService.authenticaded();
        String token = jwtUtil.generateToken(user.getUsername());
        response.addHeader("Authorization","Bearer" + token);
        return ResponseEntity.noContent().build();
    }

}