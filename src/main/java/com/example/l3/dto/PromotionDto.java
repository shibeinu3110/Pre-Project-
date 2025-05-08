package com.example.l3.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PromotionDto {
    private Long id;
    @NotNull(message = "employee id can't be null")
    private Long employeeId;
    private Long leaderId;
    private LocalDate createDate;
    private String createdBy;
    private String reason;
    private String status;

    @NotNull(message = "old position can't be null")
    private String oldPosition;
    @NotNull(message = "new position can't be null")
    private String newPosition;

    //manager submit
    private LocalDate submitDate;

    //leader accept or reject
    private LocalDate rejectDate;
    private String rejectReason;
    private LocalDate acceptDate;
    private String note;
    private LocalDate additionalDate;
    private String additionalReason;
}
