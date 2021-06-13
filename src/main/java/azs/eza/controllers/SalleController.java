package azs.eza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import azs.eza.entities.Salle;
import azs.eza.repository.SalleRepository;

@RestController
public class SalleController {

	private static final HttpStatus ResponseEntity = null;
	@Autowired
	SalleRepository salRepo;
	
	public SalleController(SalleRepository salRepo) {
		this.salRepo = salRepo;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/addSalle")
	public ResponseEntity<Salle> addSalle(@RequestBody Salle salle){
		Salle returnStatement = salRepo.save(salle);
		return new ResponseEntity<Salle>(returnStatement, HttpStatus.ACCEPTED);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(path = "/getAllSales")
	public ResponseEntity<List<Salle>> getAllSales(){
		List<Salle> returnStatement = salRepo.findAll();
		return new ResponseEntity<List<Salle>>(returnStatement, HttpStatus.ACCEPTED);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping(path = "/getOneSalle/{id}")
	public ResponseEntity<?> deleteSalle(@RequestParam("id") Long id){
		salRepo.delete(salRepo.getById(id));
		return new  ResponseEntity<>(HttpStatus.OK);
	}

}
