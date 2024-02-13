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
@Table(name = "contacts")
public class Contact {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false,length = 50)
    private String name;

    @Column(name = "surname",nullable = false,length = 50)
    private String surname;

    @Column(name = "email",nullable = false,length = 100)
    private String email;

    @Column(name = "phone",nullable = false,length = 15)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "merchant_id",referencedColumnName = "id")
    private Merchant merchant;
}
