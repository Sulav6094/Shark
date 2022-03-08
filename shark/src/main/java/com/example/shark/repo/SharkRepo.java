package com.example.shark.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shark.entity.Shark;


@Repository
public interface SharkRepo extends JpaRepository<Shark, Long>{

}
