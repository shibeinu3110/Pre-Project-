package com.example.l3.mapper;

import com.example.l3.consts.StoredProcedureConst;
import com.example.l3.dto.ProfileEndDto;
import com.example.l3.dto.RegistrationDto;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@SqlResultSetMapping(
        name = StoredProcedureConst.Mapper.PROFILE_END_DTO_MAPPER,
        classes = @ConstructorResult(
                targetClass = ProfileEndDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "registration_id", type = Long.class),
                        @ColumnResult(name = "leader_id", type = Long.class),
                        @ColumnResult(name = "end_date", type = LocalDate.class),
                        @ColumnResult(name = "end_by", type = String.class),
                        @ColumnResult(name = "reason", type = String.class),
                        @ColumnResult(name = "status", type = String.class),
                        @ColumnResult(name = "submit_date", type = LocalDate.class),
                        @ColumnResult(name = "reject_date", type = LocalDate.class),
                        @ColumnResult(name = "reject_reason", type = String.class),
                        @ColumnResult(name = "accept_date", type = LocalDate.class),
                        @ColumnResult(name = "additional_date", type = LocalDate.class),
                        @ColumnResult(name = "additional_reason", type = String.class),
                        @ColumnResult(name = "storage_number", type = Long.class)
                }
        )
)
public class ProfileEndDtoMapper {
    @Id
    private Long dummyId;
}
