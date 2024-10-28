package com.moneyMaster.Money_Master_WebWizard.service;

import com.moneyMaster.Money_Master_WebWizard.model.CurrentUser;

import java.util.List;

public interface UserService {
    CurrentUser saveUser(CurrentUser user);

    List<CurrentUser> getAllUsers();
    CurrentUser getUser(int id);
}
