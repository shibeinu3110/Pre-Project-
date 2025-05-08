package com.example.l3.mapper;

import com.example.l3.consts.StoredProcedureConst.Mapper;
import com.example.l3.dto.CertificateDto;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@SqlResultSetMapping(
        name = Mapper.CERTIFICATE_DTO_MAPPER,
        classes = @ConstructorResult(
                targetClass = CertificateDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "employee_id", type = Long.class),
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "start_date", type = LocalDate.class),
                        @ColumnResult(name = "content", type = String.class),
                        @ColumnResult(name = "field", type = String.class)
                }
        )


)
public class CertificateDtoMapper {
    @Id
    private Long dummyId;
}
