package com.krpk.lettnet.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table
@ToString
@EqualsAndHashCode(of = {"id"})
@Data
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(Views.Id.class)
    private Long id;

    @JsonView(Views.IdName.class)
    private String text;

    @JsonView(Views.IdName.class)
    private LocalDateTime publicationDate;

    private String images;
    private String files;

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false)
    @JsonView(Views.IdName.class)
    private User author;

}
