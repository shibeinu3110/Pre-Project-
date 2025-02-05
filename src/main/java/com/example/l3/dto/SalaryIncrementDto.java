package com.example.l3.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SalaryIncrementDto {
    private Long id;
    @NotNull(message = "employee id can't be null")
    private Long employeeId;
    private Long leaderId;
    private LocalDate createDate;
    private String createdBy;
    private String reason;
    private String status;
    private String salaryLevel;

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
