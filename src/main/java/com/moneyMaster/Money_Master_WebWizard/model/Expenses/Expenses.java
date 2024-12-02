package com.moneyMaster.Money_Master_WebWizard.model.Expenses;

import com.moneyMaster.Money_Master_WebWizard.model.CurrentUser;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Expenses")
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotNull(message = "User is required")
//    @Column(name = "user_id")
//    private Long userId;

    @NotNull(message = "Amount cannot be empty")
    @Column(name = "amount")
    private BigDecimal amount;

    @NotNull(message = "Date and time cannot be null")
    @Column(name = "happen_date", nullable = false)
    private Date happenDate;

    @NotNull(message = "Description cannot be Empty")
    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "expenses_category_id", referencedColumnName = "id")
    private ExpensesCategory expensesCategory;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "username")
    private CurrentUser user;
}
