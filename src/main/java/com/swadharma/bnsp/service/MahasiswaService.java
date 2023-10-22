package com.swadharma.bnsp.service;

import com.swadharma.bnsp.entity.Mahasiswa;
import com.swadharma.bnsp.payload.MahasiswaDto;
import com.swadharma.bnsp.repository.MahasiswaRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MahasiswaService {
    MahasiswaRepository mahasiswaRepository;

    public MahasiswaService(MahasiswaRepository mahasiswaRepository) {
        this.mahasiswaRepository = mahasiswaRepository;
    }

    public MahasiswaDto createNewMahasiswa(MahasiswaDto nilaiMhs){
        Mahasiswa mahasiswa = mapToEntity(nilaiMhs);
        Mahasiswa newMhs = mahasiswaRepository.save(mahasiswa);
        MahasiswaDto res = mapToDto(newMhs);

        return  res;
    }

    public List<MahasiswaDto> getAllMahasiswa(){
        List<Mahasiswa> mahasiswas = mahasiswaRepository.findAll();
        return mahasiswas.stream().map(mhs -> mapToDto(mhs)).collect(Collectors.toList());
    }


    public MahasiswaDto mapToDto(Mahasiswa mahasiswa){
        MahasiswaDto mahasiswaDto = new MahasiswaDto();

        Date oldate = mahasiswa.getTanggal_lahir();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formatedDate = simpleDateFormat.format(oldate);

        mahasiswaDto.setNim(mahasiswa.getNim());
        mahasiswaDto.setNama(mahasiswa.getNama());
        mahasiswaDto.setProgram_studi(mahasiswa.getProgram_studi());
        mahasiswaDto.setTempat_lahir(mahasiswa.getTempat_lahir());
        mahasiswaDto.setTanggal_lahir(formatedDate);
        mahasiswaDto.setKelas(mahasiswa.getKelas());
        mahasiswaDto.setIpk(mahasiswa.getIpk());

        return mahasiswaDto;
    }

    public Mahasiswa mapToEntity(MahasiswaDto mahasiswaDto){
        Mahasiswa mahasiswa = new Mahasiswa();
        String tanggalLahir = mahasiswaDto.getTanggal_lahir();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = dateFormat.parse(tanggalLahir);

            mahasiswa.setNim(mahasiswaDto.getNim());
            mahasiswa.setNama(mahasiswaDto.getNama());
            mahasiswa.setProgram_studi(mahasiswaDto.getProgram_studi());
            mahasiswa.setTempat_lahir(mahasiswaDto.getTempat_lahir());
            mahasiswa.setTanggal_lahir(date);
            mahasiswa.setKelas(mahasiswaDto.getKelas());
            mahasiswa.setIpk(mahasiswaDto.getIpk());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return mahasiswa;

    }
}
