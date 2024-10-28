package com.moneyMaster.Money_Master_WebWizard.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("User Not Found");
    }

    public UserNotFoundException(String message){
        super(message);
    }
}
