package azs.eza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import azs.eza.entities.Enseignant;
import azs.eza.entities.Etudiants;
import azs.eza.entities.Groupe;
import azs.eza.repository.EnseignantRepository;
import azs.eza.repository.EtudiantsRepository;
import azs.eza.repository.GroupeRepository;

@RestController
public class GroupeController {

	@Autowired
	GroupeRepository groupRepo; 
	EnseignantRepository ensRepo;
	EtudiantsRepository etudRepo;
	public GroupeController(GroupeRepository groupRepo) {
		this.groupRepo = groupRepo;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/addGroup/{nomGroupe}/{idEns}/{idDlg}")
	public ResponseEntity<Groupe> addOne(@RequestParam("nomGroupe") String nom, 
			@RequestParam("idEns") Long idEns, @RequestParam("idDlg") Long idDlg){
		Enseignant ens =  ensRepo.getById(idEns);
		Etudiants etud = etudRepo.getById(idDlg);
		Groupe returnStatement = new Groupe(idEns+idDlg, nom, etud, ens);
		return new ResponseEntity<Groupe>(returnStatement, HttpStatus.ACCEPTED);
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping(path = "/setDlgGroup/{idDlg}/{idGroup)")
	public ResponseEntity<Groupe> setGroupDlg(@RequestParam("idDlg") Long idDlg, @RequestParam("idGroup") Long idGrp){
		Etudiants toUpdate = etudRepo.getById(idDlg);
		Groupe returnStatement = groupRepo.getById(idGrp);
		returnStatement.setEt(toUpdate);
		return new ResponseEntity<Groupe>(returnStatement, HttpStatus.ACCEPTED);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/getAllGroups")
	public ResponseEntity<List<Groupe>> getAllGroups(){
		List<Groupe> returnStatement = groupRepo.findAll();
		return new ResponseEntity<List<Groupe>>(returnStatement, HttpStatus.ACCEPTED);
	}
	@CrossOrigin(origins = "*")
	@PutMapping(path = "/setRespGroup/{idResp}/{idGroup)")
	public ResponseEntity<Groupe> setGroupeResp(@RequestParam("idResp") Long idResp, @RequestParam("idGroup") Long idGrp){
		Enseignant toUpdate = ensRepo.getById(idResp);
		Groupe returnStatement = groupRepo.getById(idGrp);
		returnStatement.setEs(toUpdate);
		return new ResponseEntity<Groupe>(returnStatement, HttpStatus.ACCEPTED);
	}
}
