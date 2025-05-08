package com.example.l3.mapper;

import com.example.l3.consts.StoredProcedureConst;
import com.example.l3.dto.RegistrationDto;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@SqlResultSetMapping(
        name = StoredProcedureConst.Mapper.REGISTRATION_DTO_MAPPER,
        classes = @ConstructorResult(
                targetClass = RegistrationDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "employee_id", type = Long.class),
                        @ColumnResult(name = "leader_id", type = Long.class),
                        @ColumnResult(name = "create_date", type = LocalDate.class),
                        @ColumnResult(name = "created_by", type = String.class),
                        @ColumnResult(name = "content", type = String.class),
                        @ColumnResult(name = "status", type = String.class),
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
public class RegistrationDtoMapper {
    @Id
    private Long dummyId;
}
