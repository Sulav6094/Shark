package com.example.shark.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.shark.entity.Shark;
import com.example.shark.repo.SharkRepo;

@Service
public class SharkService implements ServiceMethods<Shark> {
	// NOT making a new object, creating a variable of the type SharkRepo
	private SharkRepo repo;

	// Constructor
	public SharkService(SharkRepo repo) {
				this.repo = repo;
			}

	@Override
	public Shark create(Shark shark) {
		// TODO Auto-generated method stub
		return this.repo.save(shark);
	}

	@Override
	public List<Shark> readAll() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}

	@Override
	public Shark readById(long id) {
		// TODO Auto-generated method stub
		Optional<Shark> getShark = this.repo.findById(id);
		if(getShark.isPresent()) {
			return getShark.get();
		}
		return null;
	}

	@Override
	public Shark update(long id, Shark shark) {
		// TODO Auto-generated method stub
		Optional<Shark> existingShark = this.repo.findById(id);
		if(existingShark.isPresent()) {
			Shark exists = existingShark.get();
			exists.setAge(shark.getAge());
			exists.setGender(shark.getGender());
			exists.setHabitat(shark.getHabitat());
			exists.setName(shark.getName());
			
			return this.repo.saveAndFlush(exists);
		}
		return null;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
