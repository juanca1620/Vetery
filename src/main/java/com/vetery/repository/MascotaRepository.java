package com.vetery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetery.entity.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long>{

}
