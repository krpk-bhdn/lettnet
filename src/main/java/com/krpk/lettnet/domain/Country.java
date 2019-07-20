package com.krpk.lettnet.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Country {
    @Id
    private String id;
    private String name;
}
