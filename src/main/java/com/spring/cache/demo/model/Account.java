package com.spring.cache.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "accounts")
public class Account {
    @Id
    private Long accountId;

}
