package com.sam.minicinemaapi.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rooms")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Room extends BaseEntity {
    @Column(name = "name", length = 64, nullable = false)
    String name;

    @Column(name = "capacity", nullable = false)
    Integer capacity;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    List<ShowTime> showTimes;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    List<Seat> seats;
}
