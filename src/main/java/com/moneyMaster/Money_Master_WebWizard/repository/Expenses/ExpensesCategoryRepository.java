package com.moneyMaster.Money_Master_WebWizard.repository.Expenses;


import com.moneyMaster.Money_Master_WebWizard.model.Expenses.ExpensesCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpensesCategoryRepository extends JpaRepository<ExpensesCategory, Long> {
}