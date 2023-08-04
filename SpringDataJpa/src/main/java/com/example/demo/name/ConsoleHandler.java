package com.example.demo.name;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.SpringDataJpaApplication;

@Component
public class ConsoleHandler {

	Scanner scanner;

	private NamesService namesService;
	
	@Autowired
	public ConsoleHandler(NamesService namesService) {
		this.namesService = namesService;
	}
	public ConsoleHandler() {}
	
	public void handler() {
	
		scanner=new Scanner(System.in);
	
		System.out.println("------------------------------------ \n"+" QUERY = 1 \n INSERT = 2\n UPDATE = 3 \n DELETE = 4 \n");
		String read= scanner.nextLine();
		
		String [] sa= {"1","2","3","4"};
		boolean found = false;

        for (String element : sa) {
            if (read.contains(element)) {
                found = true;
                break;
            }
        }

        if (read.isEmpty() || !found) {
            System.out.println("Enter 1, 2, 3 or 4.\n");
            handler();
        }
		
	
		 switch(read){
		 
		 case "1"://Calls the query method on Service class.
			 
			 namesService.query();
			 
			 break;
		
		 case "2"://Calls the add method on Service class.
			 
			 System.out.println("Enter a name to add. \n");
			 String name= scanner.nextLine();
			 
			 System.out.println("Enter a age to add. \n");
			 int age= scanner.nextInt();
			 
			 namesService.create(name,age);
			 
			 break;
			 
		 case "3"://Calls the update method on Service class.
			 
			 System.out.println("Enter the Id´s name to update. \n");
			 int idToUpdate=scanner.nextInt();
			 scanner.nextLine();//Read the leftover.
			 
			 System.out.println("Enter the new name to add. \n");
			 String newName= scanner.nextLine();
			 
			 System.out.println("Enter the new age to add. \n");
			 int newAge=scanner.nextInt();
			 
			 namesService.update(idToUpdate,newName,newAge);
			 
			 break;
	
		 case "4"://Calls the delete method on Service class.
			 System.out.println("Enter the Id´s name to delete. \n");
			 int idToDelete=scanner.nextInt();

			 namesService.delete(idToDelete);

    		 break;
		 }
		 handler();
	}
	
}
