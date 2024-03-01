package com.movieranker.demo.others;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class CinemaFigures {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;

    private String firstname;
    private String lastname;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthday;

}
