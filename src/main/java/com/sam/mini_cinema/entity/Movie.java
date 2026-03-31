package com.sam.mini_cinema.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Movie extends BaseEntity {
    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "description")
    String description;

    @Column(name = "duration", nullable = false)
    Integer duration;

    @Column(name = "director", nullable = false)
    String director;

    @Column(name = "movie_cast", nullable = false)
    String cast;

    @Column(name = "genre", nullable = false)
    String genre;

    @Column(name = "release_date")
    Instant releaseDate;

    @Column(name = "poster_url", nullable = false)
    String posterUrl;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    List<ShowTime> showTimes;
}
