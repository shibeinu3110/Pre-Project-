package com.example.l3.mapper;

import com.example.l3.dto.SalaryIncrementDto;
import jakarta.persistence.*;

import java.time.LocalDate;

import static com.example.l3.consts.StoredProcedureConst.Mapper;

@Entity
@SqlResultSetMapping(
        name = Mapper.SALARY_INCREMENT_DTO_MAPPER,
        classes = @ConstructorResult(
                targetClass = SalaryIncrementDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "employee_id", type = Long.class),
                        @ColumnResult(name = "leader_id", type = Long.class),
                        @ColumnResult(name = "create_date", type = LocalDate.class),
                        @ColumnResult(name = "created_by", type = String.class),
                        @ColumnResult(name = "reason", type = String.class),
                        @ColumnResult(name = "status", type = String.class),
                        @ColumnResult(name = "salary_level", type = String.class),
                        @ColumnResult(name = "submit_date", type = LocalDate.class),
                        @ColumnResult(name = "reject_date", type = LocalDate.class),
                        @ColumnResult(name = "reject_reason", type = String.class),
                        @ColumnResult(name = "accept_date", type = LocalDate.class),
                        @ColumnResult(name = "note", type = String.class),
                        @ColumnResult(name = "additional_date", type = LocalDate.class),
                        @ColumnResult(name = "additional_reason", type = String.class)
                }
        )


)
public class SalaryIncrementDtoMapper {
    @Id
    private Long dummyId;
}
