package com.swadharma.bnsp.controller;

import com.swadharma.bnsp.payload.MahasiswaDto;
import com.swadharma.bnsp.service.MahasiswaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spring/bnspsert/v1/mahasiswa")
public class MahasiswaController {
    MahasiswaService mahasiswaService;

    public MahasiswaController(MahasiswaService mahasiswaService) {
        this.mahasiswaService = mahasiswaService;
    }

    @PostMapping
    public ResponseEntity<MahasiswaDto> createMahasiswa(@RequestBody MahasiswaDto mahasiswaDto){
        return new ResponseEntity<>(mahasiswaService.createNewMahasiswa(mahasiswaDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<MahasiswaDto> getDataMahasiswa(){
        return mahasiswaService.getAllMahasiswa();
    }
}
