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
public class ProfileEndDto {
    private Long id;
    @NotNull(message = "registration id can't be null")
    private Long registrationId;
    private Long leaderId;
    private LocalDate endDate;
    private String endBy;
    private String reason;
    private String status;

    //manager submit
    private LocalDate submitDate;

    //leader accept or reject
    private LocalDate rejectDate;
    private String rejectReason;
    private LocalDate acceptDate;
    private LocalDate additionalDate;
    private String additionalReason;

    private Long storageNumber;
}
