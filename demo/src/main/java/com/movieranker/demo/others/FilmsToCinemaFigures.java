package com.movieranker.demo.others;

import com.movieranker.demo.others.utils.MovieRoles;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class FilmsToCinemaFigures {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "film_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Films film;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="cinema_figure_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CinemaFigures cinemaFigures;

    @Enumerated(EnumType.STRING)
    private MovieRoles movieRoles;
}
