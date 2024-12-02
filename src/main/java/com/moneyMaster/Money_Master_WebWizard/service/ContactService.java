//package com.moneyMaster.Money_Master_WebWizard.service;
//
//import com.moneyMaster.Money_Master_WebWizard.model.Contact;
//import com.moneyMaster.Money_Master_WebWizard.model.ContactResponseDto;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.data.domain.Sort;
//
//import java.util.List;
//
//public interface ContactService {
//    Contact saveContact(Contact contact, HttpServletRequest request);
//    ContactResponseDto getContact(int id);
//    //List<Contact> getContactsByUserId(int userId);
//    List<ContactResponseDto> getContactsByUserId(HttpServletRequest request);
//
//    List<Contact> getAllContact(int pageNo, int recordsCounts, String sortBy, Sort.Direction sortOrder);
//    Contact editContact(int id, Contact contact);
//    Contact deleteContact(int id);
//
//    List<Contact> searchContacts(String name,String searchBy, int pageNo, int recordsCounts, String sortBy, Sort.Direction sortOrder);
//}
