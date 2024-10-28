package com.moneyMaster.Money_Master_WebWizard.controller;

import com.moneyMaster.Money_Master_WebWizard.model.Contact;
import com.moneyMaster.Money_Master_WebWizard.model.ContactResponseDto;
import com.moneyMaster.Money_Master_WebWizard.service.ContactService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping
    ResponseEntity<Contact> saveContact(@RequestBody Contact contact, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(contactService.saveContact(contact, request));
    }

    @GetMapping("/{id}")
    ResponseEntity<ContactResponseDto> getContact(@PathVariable int id){
        System.out.println("return results");
        return ResponseEntity.status(HttpStatus.OK).body(contactService.getContact(id));
    }


    @GetMapping("/all")
    ResponseEntity<List<Contact>> getAllContact(@RequestParam int pageNo, @RequestParam int recordsCount,@RequestParam String sortBy, @RequestParam Sort.Direction sortOrder){
        return ResponseEntity.status(HttpStatus.OK).body(contactService.getAllContact(pageNo, recordsCount, sortBy, sortOrder));
    }

    @PutMapping("/{id}")
    ResponseEntity<Contact> editContact(@PathVariable int id, @RequestBody Contact contact){
        return ResponseEntity.status(HttpStatus.OK).body(contactService.editContact(id, contact));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Contact> deleteContact(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(contactService.deleteContact(id));
    }

    @GetMapping("/search")
    ResponseEntity<List<Contact>> searchContacts(@RequestParam String name,@RequestParam String searchBy, @RequestParam int pageNo, @RequestParam int recordsCount,@RequestParam String sortBy, @RequestParam Sort.Direction sortOrder){
        System.out.println(searchBy);
        return ResponseEntity.status(HttpStatus.OK).body(contactService.searchContacts(name,searchBy, pageNo, recordsCount, sortBy, sortOrder));
    }

//    @GetMapping("user/{userId}")
//    ResponseEntity<List<Contact>> getAllContactByUsername(@PathVariable int userId){
//        return ResponseEntity.status(HttpStatus.OK).body(contactService.getContactsByUserId(userId));
//    }

    @GetMapping("/current-user")
    ResponseEntity<List<ContactResponseDto>> getAllContactByUsername(HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(contactService.getContactsByUserId(request));
    }
}
