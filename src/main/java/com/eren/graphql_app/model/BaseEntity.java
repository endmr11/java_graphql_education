package com.eren.graphql_app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity {
    private String ipAddress;
    private OffsetDateTime createdAt;
}
