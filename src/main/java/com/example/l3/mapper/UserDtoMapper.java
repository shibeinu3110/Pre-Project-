package com.example.l3.mapper;

import com.example.l3.dto.UserDto;
import jakarta.persistence.*;

@Entity
@SqlResultSetMapping(
        name = "UserDtoMapper",
        classes = @ConstructorResult(
                targetClass = UserDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "username", type = String.class),
                        @ColumnResult(name = "password", type = String.class),
                        @ColumnResult(name = "role_id", type = Long.class),
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "email", type = String.class),
                        @ColumnResult(name = "phone", type = String.class)
                }
        )


)
public class UserDtoMapper {
    @Id
    private Long dummyId;
}
