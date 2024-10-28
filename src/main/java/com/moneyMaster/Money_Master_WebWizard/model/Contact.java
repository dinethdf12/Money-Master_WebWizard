package com.moneyMaster.Money_Master_WebWizard.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "CONTACT")
@ToString(exclude = "currentUser")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @NotNull(message = "First name cannot be null")
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "TELEPHONE_NUMBER")
    private String phoneNumber;

    @Email(message = "Email is not in correct format")
    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "HOME_ADDRESS")
    @Size(min = 10, message = "Address must be grater than 10")
    private String homeAddress;

//    @ManyToOne
//    @JoinColumn(name = "USER_ID",referencedColumnName = "Id", nullable = false)
//    private CurrentUser currentUser;

    @ManyToOne
    @JoinColumn(name = "USER",referencedColumnName = "USERNAME", nullable = false)
    private CurrentUser currentUser;

}
