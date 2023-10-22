package com.swadharma.bnsp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private long id;
    private String nama;
    private String email;
    private String password;
    private String telepon;
}
