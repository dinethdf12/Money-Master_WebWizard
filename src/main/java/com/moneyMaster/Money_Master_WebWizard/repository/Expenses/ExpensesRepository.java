package com.moneyMaster.Money_Master_WebWizard.repository.Expenses;

import com.moneyMaster.Money_Master_WebWizard.model.CurrentUser;
import com.moneyMaster.Money_Master_WebWizard.model.Expenses.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {

    List<Expenses> findByUser(CurrentUser user);
}