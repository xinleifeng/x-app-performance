package sap.crun.performance.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sap.crun.performance.api.model.SnglRecOut;
import sap.crun.performance.api.model.SnglRecOutRepository;

@RestController
@RequestMapping("/snglrec")
public class SnglRecController {
	
	@Autowired
	SnglRecOutRepository snglRecOutRepository;

	 // Get All OUT rec  https://x-app-performance-api.cfapps.sap.hana.ondemand.com/snglrec/allouts
	@GetMapping("/allouts")
	public List<SnglRecOut> getAllNotes() {
	    return snglRecOutRepository.findAll();
	}
	
	// Get a Single  findOne(), findAll(), 
	//save(),  count(), delete() etc.
	
	@GetMapping("/outs/{transId}")
	public List<SnglRecOut> getAllNotesByTransId(@PathVariable String transId) {
	    return snglRecOutRepository.findAllTransId(transId);
	}
	
	    
	// Get a Single Note
	
//	@GetMapping("/out/{transid}")
//	public SnglRecOut getSnglRecOutByTransId(@PathVariable(value = "transId") String transid) {
//	    return SnglRecOutRepository.findById(transid);
//	            //.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
//	}
	
	// Get the one specified with TransID All OUT rec  https://x-app-performance-api.cfapps.sap.hana.ondemand.com/snglrec/allouts
	

    // Create a new 

    // Update a 

    // Delete a 
	

}
