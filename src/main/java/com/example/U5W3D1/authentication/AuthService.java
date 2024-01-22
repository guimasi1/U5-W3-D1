package com.example.U5W3D1.authentication;

import com.example.U5W3D1.exceptions.UnauthorizedException;
import com.example.U5W3D1.security.JWTTools;
import com.example.U5W3D1.user.User;
import com.example.U5W3D1.user.UserLoginDTO;
import com.example.U5W3D1.user.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UsersService usersService;
    @Autowired
    private JWTTools jwtTools;



    public String authenticateUser(UserLoginDTO body) {
        User user = usersService.findByEmail(body.email());
        System.out.println(body.email() + " email del body");
        System.out.println(user.getEmail() + " email dell'user trovato con usersService");
        System.out.println(body.password() + " password del body");
        System.out.println(user.getPassword() + " password dell'user trovato con userService");
        if(body.password().equals(user.getPassword())) {
            return jwtTools.createToken(user);
        } else {
            throw new UnauthorizedException("Errore nelle credenziali");
        }
    }


}
