package com.swadharma.bnsp.payload;

import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String nama;
    private String email;
    private String password;
    private String telepon;
}
