package com.sam.minicinemaapi.entity;

import com.sam.minicinemaapi.constant.UserStatus;
import com.sam.minicinemaapi.constant.Gender;
import com.sam.minicinemaapi.constant.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity {
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
    UserStatus status;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Booking> bookings;

    @Enumerated(EnumType.STRING)
    @Column(name = "roles")
    @Builder.Default
    Set<Role> roles = Set.of(Role.USER);
}
