package com.jeffreyahn.dojoninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jeffreyahn.dojoninja.models.Dojo;
import com.jeffreyahn.dojoninja.models.Ninja;
import com.jeffreyahn.dojoninja.repositories.DojoRepository;
import com.jeffreyahn.dojoninja.repositories.NinjaRepository;

@Service
public class DojoNinjaService {
	private final DojoRepository dojoRepository;
	private final NinjaRepository ninjaRepository;
	public DojoNinjaService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
		this.dojoRepository = dojoRepository;
		this.ninjaRepository = ninjaRepository;
	}
	public List<Dojo> findDojo(){
		return dojoRepository.findAll();
	}
	public Dojo findDojoById(Long id){
		Optional<Dojo> optDojo = dojoRepository.findById(id);
		if(optDojo.isPresent()) {
			return optDojo.get();
		} else {
			return null;
		}
	}
	public List<Ninja> findByDojo(Long id){
		return ninjaRepository.findByDojo_id(id);
	}
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
}
