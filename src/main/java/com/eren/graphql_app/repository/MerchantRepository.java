package com.eren.graphql_app.repository;

import com.eren.graphql_app.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant,Integer> {
}
