package com.moneyMaster.Money_Master_WebWizard.exceptions;

public class ContactNotFoundException extends RuntimeException{
    public ContactNotFoundException(){
        super("Contact Not Found");
    }

    public ContactNotFoundException(String message){
        super(message);
    }
}
