package com.moneyMaster.Money_Master_WebWizard.service;

import com.moneyMaster.Money_Master_WebWizard.exceptions.ContactNotFoundException;
import com.moneyMaster.Money_Master_WebWizard.model.Contact;
import com.moneyMaster.Money_Master_WebWizard.model.ContactResponseDto;
import com.moneyMaster.Money_Master_WebWizard.model.CurrentUser;
import com.moneyMaster.Money_Master_WebWizard.repository.ContactRepository;
import com.moneyMaster.Money_Master_WebWizard.repository.UserRepository;
import com.moneyMaster.Money_Master_WebWizard.security.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    private final UserRepository userRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactServiceImpl.class);

    @Override
    public Contact saveContact(Contact contact, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        String user = JwtUtil.getClaims(token).getSubject();
        CurrentUser currentUser =  userRepository.findByUsername(user);

        Contact newContact = new Contact();
        newContact.setFirstName(contact.getFirstName());
        newContact.setLastName(contact.getLastName());
        newContact.setEmailAddress(contact.getEmailAddress());
        newContact.setPhoneNumber(contact.getPhoneNumber());
        newContact.setHomeAddress(contact.getHomeAddress());
        newContact.setCurrentUser(currentUser);

        return contactRepository.save(newContact);
    }

    @Override
    public ContactResponseDto getContact(int id) {
        LOGGER.info("contact id is " + id);

        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contact is not here"));
        LOGGER.info("The contact info " + contact.toString());

        return new ContactResponseDto(contact);
    }



    @Override
    public Contact editContact(int id, Contact contact) {
        return null;
    }

    @Override
    public Contact deleteContact(int id) {
        return null;
    }

    @Override
    public List<Contact> getAllContact(int pageNo, int recordsCount, String sortBy, Sort.Direction sortOrder) {
        Pageable pageable = PageRequest.of(pageNo, recordsCount, Sort.by(sortOrder, sortBy));
        return contactRepository.findAll(pageable).get().toList();
    }

    @Override
    public List<Contact> searchContacts(String name,String searchBy, int pageNo, int recordsCounts, String sortBy, Sort.Direction sortOrder) {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id", "DESC"));
        return contactRepository.searchContacts(name, pageable);
    }

//    @Override
//    public List<Contact> getContactsByUserId(int userId) {
//        return contactRepository.findByCurrentUserId(userId);
//    }

    @Override
    public List<ContactResponseDto> getContactsByUserId(HttpServletRequest request) {

        String token = request.getHeader("Authorization").substring(7);
        String username = JwtUtil.getClaims(token).getSubject();
        List<Contact> contacts = contactRepository.findByCurrentUserUsername(username);
        return contacts.stream().map(ContactResponseDto::new).toList();

    }
}
