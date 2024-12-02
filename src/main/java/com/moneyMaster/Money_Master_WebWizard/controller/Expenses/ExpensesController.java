package com.moneyMaster.Money_Master_WebWizard.controller.Expenses;

import com.moneyMaster.Money_Master_WebWizard.model.Expenses.Expenses;
import com.moneyMaster.Money_Master_WebWizard.service.Expenses.ExpensesServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class ExpensesController {

    @Autowired
    ExpensesServiceImpl expensesService;

    @GetMapping("/expenses")
    public ResponseEntity<List<Expenses>> getAllExpenses(){
        return  ResponseEntity.ok(expensesService.getAllExpenses());
    }

    @GetMapping("/expenses/user/{userName}")
    public ResponseEntity<List<Expenses>> getUserExpenses(@PathVariable("userName") String userName){
        return  ResponseEntity.ok(expensesService.getUserExpenses(userName));
    }

    @PostMapping("/expenses")
    public ResponseEntity<Expenses> createExpenses(@Valid @RequestBody Expenses expenses) {
        return new ResponseEntity<>(expensesService.createExpenses(expenses), HttpStatus.CREATED);
    }



}
