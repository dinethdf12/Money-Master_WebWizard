package com.moneyMaster.Money_Master_WebWizard.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private int status;
    private HttpStatus error;
    private List<String> messages;
}
