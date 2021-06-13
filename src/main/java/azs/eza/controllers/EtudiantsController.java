package azs.eza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import azs.eza.entities.Etudiants;
import azs.eza.entities.Groupe;
import azs.eza.repository.EtudiantsRepository;
import azs.eza.repository.GroupeRepository;

@RestController
public class EtudiantsController {
	
	@Autowired
	EtudiantsRepository etudRepo;
	
	GroupeRepository groupRep;
	
	public EtudiantsController(EtudiantsRepository etudRepo) {
		this.etudRepo = etudRepo;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/getAllEtuds")
	public ResponseEntity<List<Etudiants>> getAll(){
		List<Etudiants> returnStatement = etudRepo.findAll();
		return new ResponseEntity<List<Etudiants>>(returnStatement, HttpStatus.ACCEPTED);
	}
	

	@CrossOrigin(origins = "*")
	@GetMapping(path = "/getEtudByGroupId/{id}")
	public ResponseEntity<List<Etudiants>> getByGroup(@RequestParam("id") Long id) {
		List<Etudiants> returnStatement = etudRepo.findByGrIdGEquals(id);
		return new ResponseEntity<List<Etudiants>>(returnStatement, HttpStatus.ACCEPTED);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(path = "/getEtudById/{id}")
	public ResponseEntity<Etudiants> getEtudById(@RequestParam("id") Long id) {
		Etudiants returnStatement = etudRepo.getById(id);
		return new ResponseEntity<Etudiants>(returnStatement, HttpStatus.ACCEPTED);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/addOneEtudiant")
	public ResponseEntity<Etudiants> addEtudiant(@RequestBody Etudiants etudiant){
		Etudiants returnStatement = etudRepo.save(etudiant);
		return new ResponseEntity<Etudiants>(returnStatement,HttpStatus.ACCEPTED);
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping(path = "/setEtudGroup/{idEtud}/{idGroup}")
	public ResponseEntity<?> setEtudGroup(@RequestParam("idEtud") Long idEtudiant, @RequestParam("idGroup") Long groupId){
		Etudiants subject = etudRepo.getById(idEtudiant);
		Groupe index = groupRep.getById(groupId);
		try {
			subject.setGr(index);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
			} catch (Exception e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
				
			}
	}
	
	
























}

