package com.example.l3.service;

import com.example.l3.dto.CertificateDto;

import java.util.List;


public interface CertificateService {
    CertificateDto createCertificate(CertificateDto certificateDto);

    List<CertificateDto> getAllCertificate();

    CertificateDto getCertificateById(Long id);

    void deleteCertificateById(Long id);

    List<CertificateDto> getCertificateByEmployeeId(Long id);

    CertificateDto updateCertificate(Long id, CertificateDto certificateDto);
}
