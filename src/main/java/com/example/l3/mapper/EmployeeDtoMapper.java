package com.example.l3.mapper;

import com.example.l3.dto.EmployeeDto;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@SqlResultSetMapping(
        name = "EmployeeDtoMapper",
        classes = @ConstructorResult(
                targetClass = EmployeeDto.class,
                columns = {
                        @ColumnResult(name = "employee_id", type = Long.class),
                        @ColumnResult(name = "employee_name", type = String.class),
                        @ColumnResult(name = "employee_code", type = String.class),
                        @ColumnResult(name = "gender", type = String.class),
                        @ColumnResult(name = "date_of_birth", type = LocalDate.class),
                        @ColumnResult(name = "address", type = String.class),
                        @ColumnResult(name = "team", type = String.class),
                        @ColumnResult(name = "image_url", type = String.class),
                        @ColumnResult(name = "postcode", type = String.class),
                        @ColumnResult(name = "phone_number", type = String.class),
                        @ColumnResult(name = "email", type = String.class),
                        @ColumnResult(name = "manager_created", type = String.class)
                }
        )


)
public class EmployeeDtoMapper {
    @Id
    private Long dummyId;
}
