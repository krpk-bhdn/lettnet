package com.krpk.lettnet.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "usr")
@Data
public class User implements Serializable {
    @Id
    private String id;
    private String name;
    private String email;
    private String locale;
    private String picture;
    private LocalDateTime lastVisit;
}
