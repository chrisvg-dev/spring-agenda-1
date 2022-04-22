package com.cvg.agenda.dto;

import com.cvg.agenda.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDTO {
    private Integer id;
    private String activity;
    private String date;
    private Float estimated;
}
