package com.eazybytes.accounts.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Accounts extends BaseEntity {

    @Id
    @Column(name = "account_no")
    private Long AccountNo;

    @Column(name = "customer_id")
    private Long customerId;
    private String branchAddress;

}
