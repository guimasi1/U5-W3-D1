package com.example.U5W3D1.user;

import com.example.U5W3D1.device.Device;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue
    private UUID id;
    @Column(unique = true)
    private String username;
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Device> deviceList;
    private String avatarUrl;
    private String password;

    public User(String username, String name, String surname, String email, String avatarUrl) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.avatarUrl = avatarUrl;
    }
}
