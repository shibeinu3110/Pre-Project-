package com.example.l3.mapper;

import com.example.l3.dto.RoleDto;
import jakarta.persistence.*;


@Entity
@SqlResultSetMapping(
        name = "RoleDtoMapper",
        classes = @ConstructorResult(
                targetClass = RoleDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "role", type = String.class)
                }
        )
)
public class RoleDtoMapper {
    @Id
    private Long dummyId;
}
