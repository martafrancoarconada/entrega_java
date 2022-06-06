package com.mascotas.adopt.data;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mascotas.adopt.model.Mascota;

public interface MascotaRepository extends PagingAndSortingRepository<Mascota, Long> {

}
