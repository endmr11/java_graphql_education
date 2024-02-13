package com.eren.graphql_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "addresses")
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "city",nullable = false,length = 50)
    private String city;

    @Column(name = "country",nullable = false,length = 50)
    private String country;

    @Column(name = "street",nullable = false,length = 50)
    private String street;

    @Column(name = "zip_code",nullable = false,length = 10)
    private String zipCode;

    @OneToOne(mappedBy = "address",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Merchant merchant;
}
