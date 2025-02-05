package com.example.l3.controller;

import com.example.l3.commons.OctResponse;
import com.example.l3.dto.CertificateDto;
import com.example.l3.service.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/certificate")
public class CertificateController {
    private final CertificateService certificateService;
    @PostMapping()
    public OctResponse<CertificateDto> createCertificate(@RequestBody CertificateDto certificateDto) {
        CertificateDto certificateDto1 = certificateService.createCertificate(certificateDto);
        return OctResponse.build(certificateDto1,"create new certificate successfully");
    }


    @GetMapping("/getAll")
    public OctResponse<List<CertificateDto>> getAllCertificate() {
        return OctResponse.build(certificateService.getAllCertificate(), "get all certificate successfully");
    }

    @GetMapping("/{id}")
    public OctResponse<CertificateDto> getCertificateById(@PathVariable("id") Long id) {
        return OctResponse.build(certificateService.getCertificateById(id), "get certificate with id: " + id + " successfully");
    }

    @DeleteMapping("/{id}")
    public OctResponse<String> deleteCertificateById(@PathVariable("id") Long id) {
        certificateService.deleteCertificateById(id);
        return OctResponse.build("delete certificate with id:" + id + " successfully");
    }

    @GetMapping("/employee/{id}")
    public OctResponse<List<CertificateDto>> getCertificateByEmployeeId(@PathVariable("id") Long id) {
        List<CertificateDto> certificateDtoList = certificateService.getCertificateByEmployeeId(id);

        return OctResponse.build(certificateDtoList, "get all certificates of employee with id: " + id);
    }
    @PutMapping("/{id}")
    public OctResponse<CertificateDto> updateCertificate(@PathVariable("id") Long id,
                                                         @RequestBody CertificateDto certificateDto) {
        return OctResponse.build(certificateService.updateCertificate(id, certificateDto), "update certificate with id:" + id + " successfully");
    }
}
