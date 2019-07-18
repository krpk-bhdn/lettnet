package com.krpk.lettnet.domain;

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
    private Long id;
    @Column(length = 5000)
    private String text;

    private LocalDateTime publicationDate;

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false)
    private User author;

}
