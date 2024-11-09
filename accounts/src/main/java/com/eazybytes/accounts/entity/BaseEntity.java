package com.eazybytes.accounts.entity;

import com.eazybytes.accounts.auditor.AuditAwareImpl;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
//to auto populate the createdAt, createdBy, lastModifiedAt, lastModifiedBy fields of any entity that extends this class
@Getter @Setter @ToString
public class BaseEntity {
    @CreatedDate
    @Column(updatable = false) //to prevent the update of the createdAt field
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(updatable = false) //to prevent the update of the createdBy field
    private String createdBy;

    @LastModifiedDate
    @Column(insertable = false) //to prevent the update of the updatedAt field at the time of creation
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(insertable = false) //to prevent the update of the updatedBy field at the time of creation
    private String updatedBy;

}
