package com.moneyMaster.Money_Master_WebWizard.model.Expenses;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Expenses_Category")
public class ExpensesCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(name = "name")
    @NotNull(message = "Name cannot be empty")
    @NotBlank(message = "Name cannot be empty")
    private String name;


    @Column(name = "description")
    @NotNull(message = "Description cannot be empty")
    @NotBlank(message = "Description cannot be empty")
    private String description;


}