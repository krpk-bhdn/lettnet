package com.krpk.lettnet.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@ToString
@EqualsAndHashCode(of = {"id"})
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(Views.Id.class)
    private Long id;
    @Column(length = 5000)
    @JsonView(Views.IdName.class)
    private String text;

    @JsonView(Views.IdName.class)
    private LocalDateTime publicationDate;

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false)
    @JsonView(Views.IdName.class)
    private User author;

}
