package com.cvg.agenda.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String activity;
    private LocalDateTime date;
    private Float estimated;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_status", referencedColumnName = "id")
    private Status status;

    private LocalDateTime createdAt;
}
