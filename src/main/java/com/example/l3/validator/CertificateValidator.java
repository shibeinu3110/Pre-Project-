package com.example.l3.validator;

import com.example.l3.commons.exception.ErrorMessages;
import com.example.l3.commons.exception.OctException;
import com.example.l3.dto.CertificateDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;

import static com.example.l3.consts.ConstParameter.EMPTY_INDEX;
import static com.example.l3.consts.StoredProcedureConst.Certificate;
import static com.example.l3.consts.StoredProcedureConst.Parameter;

@Component
@RequiredArgsConstructor
public class CertificateValidator {
    private final EntityManager entityManager;

    public void checkExistCertificate(Long id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Certificate.EXIST_CERTIFICATE_BY_ID)
                .registerStoredProcedureParameter(Parameter.CERTIFICATE_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.CERTIFICATE_ID, id);


        Number result = (Number) query.getSingleResult();

        if (ObjectUtils.isEmpty(result) || result.intValue() == EMPTY_INDEX) {
            throw new OctException(ErrorMessages.NOT_FOUND, "can't find certificate with id: " + id);
        }
    }

    public void checkValidCertificate(CertificateDto certificateDto) {
        checkDate(certificateDto.getStartDate());
    }

    private void checkDate(LocalDate startDate) {
        if (startDate.isAfter(LocalDate.now())) {
            throw new OctException(ErrorMessages.INVALID_FORMAT, "start date invalid");
        }
    }
}
