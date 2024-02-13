package com.eren.graphql_app.controller;

import com.eren.graphql_app.model.Address;
import com.eren.graphql_app.model.Contact;
import com.eren.graphql_app.model.Merchant;
import com.eren.graphql_app.repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantRepository merchantRepository;


    @MutationMapping
    public Merchant createMerchant(@Argument("merchant") Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @QueryMapping
    public List<Merchant> getMerchants() {
        return merchantRepository.findAll();
    }

    @QueryMapping
    public Merchant getMerchantId(@Argument("id") Integer id) {
        return merchantRepository.findById(id).orElseThrow(() -> new RuntimeException("Merchant not found with id: " + id.toString()));
    }

    @SchemaMapping
    public List<Contact> contacts(Merchant merchant) {
        return merchant.getContacts();
    }

    @SchemaMapping
    public Address address(Merchant merchant) {
        return merchant.getAddress();
    }
}

/*
query {
  getMerchantId(id:1) {
    id,
    name,
    surname,
    contacts {
      name,
      phone
    }
  }
}
---------------------
query {
  getMerchants {
    id,
    name,
    surname,
    contacts {
      name,
      phone
    }
  }
}
---------------------
mutation {
  createMerchant(merchant: {
    name: "Eren",
    surname: "Demir",
    taxNumber: "101010010101",
    identityNumber: "1231231",
    companyType: INDIVIDUAL,
    address: {
      country: "Beşiktaş",
      city: "İstanbul",
      zipCode: "34000",
      street: "Akaretler"
    }
    contacts: [{
      name: "Eren",
      surname: "Demir",
      email: "erndemir.1@gmail.com",
      phone: "+905555555555"
    }]
  }) {
    id,
    name,
    surname,
    contacts {
      name,
      phone
    }
  }
}

*/


