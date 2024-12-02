package com.moneyMaster.Money_Master_WebWizard.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@Table(name = "user")
public class CurrentUser {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID")
//    private int id;

    @Id
    @Column(name = "username")
    @NotNull(message = "Username cannot be null")
    private String username;

    @Column(name = "password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password cannot be null")
    private String password;

    @Column(name = "name")
    @NotNull(message = "Name cannot be null")
    private String name;

    @Column(name = "mobile_number")
    @NotNull(message = "Mobile Number cannot be null")
    private String mobileNumber;

    @Column(name = "role")
    @NotNull(message = "Role cannot be null")
    private String role;

//    @JsonIgnore
//    @OneToMany(mappedBy = "currentUser")
//    private List<Contact> contacts;

    public CurrentUser(){}

    public CurrentUser(String username, String password, String name, String mobileNumber, String role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.role = role;
    }
}
