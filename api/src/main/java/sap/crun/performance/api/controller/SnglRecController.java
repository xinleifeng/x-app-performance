package sap.crun.performance.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import sap.crun.performance.api.model.SnglRecOut;
import sap.crun.performance.api.model.SnglRecOutRepository;

@RestController
@RequestMapping("/snglrec")
public class SnglRecController {

	@Autowired
	SnglRecOutRepository snglRecOutRepository;

	// Get All OUT rec
	// https://x-app-performance-api.cfapps.sap.hana.ondemand.com/snglrec/allouts
	@GetMapping("/allouts")
	public List<SnglRecOut> getAllNotes() {
		return snglRecOutRepository.findAll();
	}

	// Get a Single findOne(), findAll(),
	// save(), count(), delete() etc.
	@GetMapping("/out/{transId}")
	public List<SnglRecOut> getAllNotesByTransId(@PathVariable String transId) {
		return snglRecOutRepository.findAllTransId(transId);
	}

	@PostMapping("/outs")
	// SnglRecOut newSnglRecOut(@RequestBody SnglRecOut newSnglRecOut) {
	public void newSnglRecOut(@RequestBody SnglRecOut[] newSnglRecOuts) {
		for (int i = 0; i < newSnglRecOuts.length; i++) {
			snglRecOutRepository.insertNewSnglRecOut(newSnglRecOuts[i]);
		}

	}

	//update
	@PutMapping("/outs")
	public void updateSnglRecOut(@RequestBody SnglRecOut[] newSnglRecOuts) {
		for (int i = 0; i < newSnglRecOuts.length; i++) {
			snglRecOutRepository.updateByTransId(newSnglRecOuts[i]);
		}
	}

	//delete
	@DeleteMapping("/out/{transId}")
	void deleteSnglRecOut(@PathVariable String transId) {
		snglRecOutRepository.deleteByTransId(transId);
	}
}
