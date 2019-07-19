package com.krpk.lettnet.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
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
    @JsonView(Views.Id.class)
    private String id;
    @JsonView(Views.IdName.class)
    private String name;
    private String email;
    private String locale;
    @JsonView(Views.IdName.class)
    private String picture;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "EEEE, MMMM dd, yyyy, hh:mm a")
    private LocalDateTime lastVisit;
}
