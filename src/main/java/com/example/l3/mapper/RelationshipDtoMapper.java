package com.example.l3.mapper;

import com.example.l3.dto.EmployeeDto;
import com.example.l3.dto.RelationshipDto;
import jakarta.persistence.*;

import java.time.LocalDate;
import static com.example.l3.consts.StoredProcedureConst.*;
@Entity
@SqlResultSetMapping(
        name = Mapper.RELATIONSHIP_DTO_MAPPER,
        classes = @ConstructorResult(
                targetClass = RelationshipDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "gender", type = String.class),
                        @ColumnResult(name = "employee_id", type = Long.class),
                        @ColumnResult(name = "date_of_birth", type = LocalDate.class),
                        @ColumnResult(name = "postcode", type = String.class),
                        @ColumnResult(name = "relationship", type = String.class),
                        @ColumnResult(name = "address", type = String.class)
                }
        )


)
public class RelationshipDtoMapper {
    @Id
    private Long dummyId;
}
