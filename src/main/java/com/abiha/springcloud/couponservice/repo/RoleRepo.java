package com.abiha.springcloud.couponservice.repo;

import com.abiha.springcloud.couponservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
}
