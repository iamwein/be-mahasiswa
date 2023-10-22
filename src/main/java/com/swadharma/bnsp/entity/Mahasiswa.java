package com.swadharma.bnsp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mahasiswa")
public class Mahasiswa {
    @Id
    private String nim;
    private String nama;
    private String tempat_lahir;
    private Date tanggal_lahir;
    private String program_studi;
    private String kelas;
    private float ipk;
}
