package com.sam.minicinemaapi.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "seats")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Seat extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    Room room;

    @Column(name = "row", nullable = false)
    Character row;

    @Column(name = "number", nullable = false)
    Byte number;
}
