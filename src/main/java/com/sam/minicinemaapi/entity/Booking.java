package com.sam.minicinemaapi.entity;

import com.sam.minicinemaapi.constant.BookingStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bookings")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Booking extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_time_id")
    ShowTime showTime;

    @Column(name = "booking_time")
    Instant bookingTime;

    @Builder.Default
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    BookingStatus status = BookingStatus.PENDING;

    @Column(name = "total_price")
    BigDecimal totalPrice;
}
