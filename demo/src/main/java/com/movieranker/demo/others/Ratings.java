package com.movieranker.demo.others;

import com.movieranker.demo.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Ratings {
    private final static int MAX_RATE = 10;
    private final static int MIN_RATE = 0;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "film_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Films film;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @Min(MIN_RATE)
    @Max(MAX_RATE)
    private Integer rating;

}
