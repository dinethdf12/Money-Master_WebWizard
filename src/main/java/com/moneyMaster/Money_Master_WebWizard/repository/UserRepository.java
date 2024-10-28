package com.moneyMaster.Money_Master_WebWizard.repository;

import com.moneyMaster.Money_Master_WebWizard.model.CurrentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<CurrentUser, Integer> {
    CurrentUser findByUsername(String username);
}
