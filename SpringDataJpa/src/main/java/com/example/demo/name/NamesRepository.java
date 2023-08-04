package com.example.demo.name;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.name.Names;

@Repository
public interface NamesRepository extends JpaRepository<Names,Integer> {


}
