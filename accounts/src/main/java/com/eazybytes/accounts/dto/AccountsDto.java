package com.eazybytes.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {
    @NotEmpty(message = "Account number cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid account number")
    private Long AccountNo;

    @NotEmpty(message = "customerId cannot be empty")
    private Long customerId;

    @NotEmpty(message = "branchAddress cannot be empty")
    private String branchAddress;
}
