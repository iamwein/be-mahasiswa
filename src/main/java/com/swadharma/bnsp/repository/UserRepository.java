package com.swadharma.bnsp.repository;

import com.swadharma.bnsp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
