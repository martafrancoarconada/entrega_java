package com.mascotas.adopt.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.mascotas.adopt.model.Mascota;
import com.mascotas.adopt.data.MascotaRepository;


@RestController
@RequestMapping(path="/rest", produces="application/json")


public class MascotaControllerAPI {

@Autowired
private MascotaRepository mascotaRepo;



// @GetMapping("/{id}")
// public Taco tacoById(@PathVariable("id") Long id) {
// Optional<Taco> optTaco = tacoRepo.findById(id);
// if(optTaco.isPresent()) {
// return optTaco.get();
// }
// return null;
// }

@GetMapping("/{id}")
public ResponseEntity<Mascota> tacoById(@PathVariable("id") Long id) {
Optional<Mascota> optMascota = mascotaRepo.findById(id);
if(optMascota.isPresent()) {
return new ResponseEntity<>(optMascota.get(), HttpStatus.OK);
}
return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
}

@PostMapping(path="/maskotas", consumes="application/json")
@ResponseStatus(HttpStatus.CREATED)
public Mascota postMascota(@RequestBody Mascota mascota) {
return mascotaRepo.save(mascota);
}

@DeleteMapping("/{id}")
@ResponseStatus(code=HttpStatus.NO_CONTENT)
public void deleteMascota(@PathVariable("id") Long id) {
mascotaRepo.deleteById(id);
}

@GetMapping("/maskotas")
public Iterable<Mascota> getAllMascotas() {
	
	return mascotaRepo.findAll();
}



}