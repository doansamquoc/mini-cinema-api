package com.sam.mini_cinema.entity;

import com.sam.mini_cinema.constant.CustomerStatus;
import com.sam.mini_cinema.constant.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer extends BaseEntity {
    @Column(name = "full_name", length = 64)
    String fullName;

    @Column(name = "gender", length = 16)
    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(name = "dob")
    LocalDate dob;

    @Column(name = "email", length = 64, unique = true)
    String email;

    @Column(name = "phone_number", length = 16, unique = true)
    String phoneNumber;

    @Column(name = "status", length = 16)
    @Enumerated(EnumType.STRING)
    CustomerStatus status;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<Booking> bookings;
}
