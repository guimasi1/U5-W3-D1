package com.example.U5W3D1.authentication;

import com.example.U5W3D1.exceptions.UnauthorizedException;
import com.example.U5W3D1.security.JWTTools;
import com.example.U5W3D1.user.User;
import com.example.U5W3D1.user.UserLoginDTO;
import com.example.U5W3D1.user.UsersService;
import com.example.U5W3D1.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private JWTTools jwtTools;

    @Autowired
    private UsersService usersService;

    public String authenticateUser(UserLoginDTO body) {
        User user = usersService.findByEmail(body.email());
        if(body.password().equals(user.getPassword())) {
            return jwtTools.createToken(user);
        } else {
            throw new UnauthorizedException("Errore nelle credenziali");
        }
    }


}
