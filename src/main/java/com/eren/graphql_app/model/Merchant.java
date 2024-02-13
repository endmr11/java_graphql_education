package com.eren.graphql_app.model;

import com.eren.graphql_app.enums.CompanyType;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "merchants")
public class Merchant extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false,length = 50)
    private String name;

    @Column(name = "surname",nullable = false,length = 50)
    private String surname;

    @Column(name = "tax_number",nullable = false,length = 100)
    private String taxNumber;

    @Column(name = "identity_number",nullable = false,length = 11)
    private String identityNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "company_type",nullable = false)
    private CompanyType companyType;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Contact> contacts;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "adress_id",referencedColumnName = "id",nullable = false)
    private Address address;

    @PrePersist
    void prePersist() {
        setIpAddress("192.1.1.1");
        setCreatedAt(OffsetDateTime.now());
    }
}
