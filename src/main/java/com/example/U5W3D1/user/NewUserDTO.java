package com.example.U5W3D1.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.aspectj.weaver.ast.Not;

import java.util.UUID;

public record NewUserDTO(

        @NotEmpty
        @Size(min = 3,max = 20, message = "L'username deve essere di minimo 3 caratteri e massimo 20")
        String username,
        @NotEmpty(message = "Inserire il nome")
        @Size(min = 3,max = 20, message = "Il nome deve essere di minimo 3 caratteri e massimo 20")
        String name,
        @NotEmpty(message = "Inserire il cognome")
        @Size(min = 3,max = 20, message = "Il cognome deve essere di minimo 3 caratteri e massimo 20")
        String surname,
        @NotEmpty(message = "Inserire l'email")
        @Email(message = "Inserire un'email valida")
        String email,
        @NotEmpty(message = "Inserire l'url dell'avatar")
        String avatarUrl,
        @NotEmpty(message = "Inserire la password")
        @Size(min = 3, max = 40, message = "La psw deve essere di minimo 3 caratteri e massimo 40.")
        String password
) {

}
