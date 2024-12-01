package com.moneyMaster.Money_Master_WebWizard.service.Expenses;

import com.moneyMaster.Money_Master_WebWizard.model.CurrentUser;
import com.moneyMaster.Money_Master_WebWizard.model.Expenses.Expenses;


import java.math.BigDecimal;
import java.util.List;

public interface ExpensesService {

    Expenses createExpenses(Expenses expenses);
    List<Expenses> getAllExpenses();
    List<Expenses> getUserExpenses();
    Expenses updateExpenses(Expenses expenses);
    Expenses deleteExpenses(Expenses expenses);
}
