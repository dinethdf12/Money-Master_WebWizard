package com.moneyMaster.Money_Master_WebWizard.repository;

import com.moneyMaster.Money_Master_WebWizard.model.Contact;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    //List<Contact> findByCurrentUserId(int userId);
    List<Contact> findByCurrentUserUsername(String username);

    @Query("SELECT c FROM Contact c WHERE c.firstName = :name OR c.lastName = :name OR c.emailAddress = :name")
    List<Contact> searchContacts(@Param("name") String name, Pageable pageable);

}
