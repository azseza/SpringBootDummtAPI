package azs.eza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import azs.eza.entities.Enseignant;
import azs.eza.repository.EnseignantRepository;

@RestController
public class EnseignantController {
	
	@Autowired
	private EnseignantRepository ensRepo;
	
	public EnseignantController(EnseignantRepository ensRepo) {
		this.ensRepo = ensRepo;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/getAllEns")
	public ResponseEntity<List<Enseignant>> getAllEns(){
		List<Enseignant> returnStatement = ensRepo.findAll();
		return new ResponseEntity<List<Enseignant>>(returnStatement,HttpStatus.ACCEPTED);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/makeOne")
	public ResponseEntity<?> makeOne(@RequestBody Enseignant ens ){
		Enseignant responsetest =  ensRepo.save(ens);
		if (responsetest == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/searchByName/{name}")
	public ResponseEntity<List<Enseignant>> searchByName(@RequestParam("name") String name ){
		List<Enseignant> returnStatement = ensRepo.findByNomEnContaining(name);
		return new ResponseEntity<List<Enseignant>>(returnStatement, HttpStatus.ACCEPTED);
	}



	@CrossOrigin(origins = "*")
	@GetMapping(path = "/getById/{id}")
	public ResponseEntity<Enseignant> getById(@RequestParam("id") Long id) {
		Enseignant returnStatement = ensRepo.getById(id);
		return new ResponseEntity<Enseignant>(returnStatement,HttpStatus.ACCEPTED);
	}
	




















































}
