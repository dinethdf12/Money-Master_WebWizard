package com.moneyMaster.Money_Master_WebWizard.service.Expenses;

import com.moneyMaster.Money_Master_WebWizard.model.CurrentUser;
import com.moneyMaster.Money_Master_WebWizard.model.Expenses.Expenses;
import com.moneyMaster.Money_Master_WebWizard.repository.Expenses.ExpensesRepository;

import com.moneyMaster.Money_Master_WebWizard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ExpensesServiceImpl implements ExpensesService {

    @Autowired
    ExpensesRepository expensesRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Expenses> getAllExpenses() {return expensesRepository.findAll();}

    @Override
    public Expenses createExpenses(Expenses expenses) {
        return expensesRepository.save(expenses);
    }

    @Override
    public List<Expenses> getUserExpenses() throws UsernameNotFoundException  {
        CurrentUser user =  userRepository.findByUsername("ddf");

        System.out.println(user);
        {return expensesRepository.findByUser(user);}
    }
    @Override
    public Expenses updateExpenses(Expenses expenses) {
        return expensesRepository.save(expenses);
    }
    @Override
    public Expenses deleteExpenses(Expenses expenses) {
        return expensesRepository.save(expenses);
    }
}
