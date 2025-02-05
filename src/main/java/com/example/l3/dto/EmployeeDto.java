package com.example.l3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {
    private Long employeeId;
    private String employeeName;
    private String employeeCode;
    private String gender;
    private LocalDate dateOfBirth;
    private String address;
    private String team;
    private String imageUrl;
    private String postcode;
    private String phoneNumber;
    private String email;

    private String managerCreated;
}
