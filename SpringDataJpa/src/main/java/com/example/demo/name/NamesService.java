package com.example.demo.name;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NamesService {

	private NamesRepository namesRepository;
	
	@Autowired
	public NamesService(NamesRepository namesRepository) {
		this.namesRepository = namesRepository;
	}

	//Query method.
	public void query() {
		List <Names> names= new ArrayList();
		names=namesRepository.findAll();
		
		StringBuilder s=new StringBuilder();
		System.out.println("------------------------------------");
		System.out.println("Id | Name | Age");
		
		 for (Names namesToDisplay : names) {
		        s.append(namesToDisplay.getId()).append(" | ")
		         .append(namesToDisplay.getName()).append(" | ")
		         .append(namesToDisplay.getAge()).append("\n");
		    }

		    System.out.println(s);
		
	}
	//Create method.
	public void create(String name, int age) {
		Names names=new Names();
		names.setName(name);
		names.setAge(age);
		
		namesRepository.save(names);
		System.out.println("Name saved!");
		
	}
    //Update method.
	public void update(int idToUpdate, String name, int age) {

		verify(idToUpdate);
		
		//Uses Optional because may throw an Exception.
		Optional <Names>nameToUpdate=namesRepository.findById(idToUpdate);
		
		Names newName=new Names();
		newName=nameToUpdate.get();
		String oldName= newName.getName();
		newName.setName(name);
		newName.setAge(age);
		
		
		namesRepository.save(newName);
		System.out.println("Name: "+ oldName + " updated to: " + name + "!");
		
		
	}
	//Delete method.
	public void delete(int idToDelete) {
		
		verify(idToDelete);
		
		namesRepository.deleteById(idToDelete);
		System.out.println("Name with Id: " + idToDelete + " deleted!" );
	}
	
     //Method to verify if the name with the given id exists.
     public void verify (int id) {
		
		boolean exist = namesRepository.existsById(id);
		
		if(exist) {
			return;
		}else {throw new IllegalStateException("Name with id"+ id +"does not exists.");
		      }
	}


}
