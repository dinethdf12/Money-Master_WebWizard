package com.moneyMaster.Money_Master_WebWizard.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@Table(name = "USER")
@ToString(exclude = "contacts")
public class CurrentUser {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID")
//    private int id;

    @Id
    @Column(name = "USERNAME")
    @NotNull(message = "Username cannot be null")
    private String username;

    @Column(name = "PASSWORD")
    @NotNull(message = "Password cannot be null")
    private String password;

    @Column(name = "ROLE")
    @NotNull(message = "Role cannot be null")
    private String role;


    @JsonIgnore
    @OneToMany(mappedBy = "currentUser")
    private List<Contact> contacts;

    public CurrentUser(){}

    public CurrentUser(String username, String password, String role){
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
