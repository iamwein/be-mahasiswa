package com.swadharma.bnsp.payload;

import lombok.Data;

import java.util.Date;

@Data
public class MahasiswaDto {
    private String nim;
    private String nama;
    private String tempat_lahir;
    private String tanggal_lahir;
    private String program_studi;
    private String kelas;
    private float ipk;
}
