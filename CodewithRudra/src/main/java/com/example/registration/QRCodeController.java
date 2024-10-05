package com.example.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.QRCodeService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/qrcode")
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @GetMapping("/generate/{userId}")
    public ResponseEntity<byte[]> generateQRCode(@PathVariable Long userId) throws Exception {
        String profileData = "https://hospital.com/profile/" + userId; // Example URL
        byte[] qrCode = qrCodeService.generateQRCode(profileData);
        
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(qrCode);
    }
}
