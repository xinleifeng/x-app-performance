package sap.crun.performance.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import sap.crun.performance.api.model.Book;
import sap.crun.performance.api.model.BookRepository;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
    BookRepository bookRepository;

	 // Get All
	@GetMapping("/books")
	public List<Book> getAllNotes() {
	    return bookRepository.findAll();
	}

    // Create a new 

    // Get a Single 

    // Update a 

    // Delete a 
	
	

}
