package com.example.l3.service.impl;

import com.example.l3.dto.CertificateDto;
import com.example.l3.helper.JsonHelper;
import com.example.l3.service.CertificateService;
import com.example.l3.validator.CertificateValidator;
import com.example.l3.validator.EmployeeValidator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.l3.consts.StoredProcedureConst.*;

@Service
@RequiredArgsConstructor

public class CertificateServiceImpl implements CertificateService {
    private final EntityManager entityManager;
    private final CertificateValidator certificateValidator;
    private final EmployeeValidator employeeValidator;

    @Override
    public CertificateDto createCertificate(CertificateDto certificateDto) {
        employeeValidator.existById(certificateDto.getEmployeeId());
        certificateValidator.checkValidCertificate(certificateDto);
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Certificate.CREATE_CERTIFICATE, Mapper.CERTIFICATE_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.CERTIFICATE_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.CERTIFICATE_JSON, JsonHelper.toJson(certificateDto));
        return (CertificateDto) query.getSingleResult();
    }

    private List<CertificateDto> mapObjectListToCertificateList(List<Object> objectList) {
        List<CertificateDto> certificateDtoList = new ArrayList<>();
        for (Object object : objectList) {
            if (object instanceof CertificateDto) {
                certificateDtoList.add((CertificateDto) object);
            }
        }
        return certificateDtoList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CertificateDto> getAllCertificate() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Certificate.GET_ALL_CERTIFICATE, Mapper.CERTIFICATE_DTO_MAPPER);

        return mapObjectListToCertificateList(query.getResultList());
    }

    @Override
    public CertificateDto getCertificateById(Long id) {
        certificateValidator.checkExistCertificate(id);
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Certificate.GET_CERTIFICATE_BY_ID, Mapper.CERTIFICATE_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.CERTIFICATE_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.CERTIFICATE_ID, id);
        return (CertificateDto) query.getSingleResult();
    }

    @Override
    public void deleteCertificateById(Long id) {
        certificateValidator.checkExistCertificate(id);
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Certificate.DELETE_CERTIFICATE_BY_ID)
                .registerStoredProcedureParameter(Parameter.CERTIFICATE_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.CERTIFICATE_ID, id);
        query.execute();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CertificateDto> getCertificateByEmployeeId(Long id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Certificate.GET_CERTIFICATE_BY_EMPLOYEE_ID, Mapper.CERTIFICATE_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.EMPLOYEE_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.EMPLOYEE_ID, id);

        return mapObjectListToCertificateList(query.getResultList());
    }

    @Override
    public CertificateDto updateCertificate(Long id, CertificateDto certificateDto) {

        certificateValidator.checkExistCertificate(id);
        certificateValidator.checkValidCertificate(certificateDto);

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Certificate.UPDATE_CERTIFICATE, Mapper.CERTIFICATE_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.CERTIFICATE_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.CERTIFICATE_ID, id)
                .registerStoredProcedureParameter(Parameter.CERTIFICATE_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.CERTIFICATE_JSON, JsonHelper.toJson(certificateDto));


        query.execute();
        return getCertificateById(id);
    }


}
