package azs.eza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import azs.eza.repository.CoursRepository;
import azs.eza.entities.Cours;

@RestController
public class CoursController {
	
	public CoursController(CoursRepository coursrepo) {
		this.coursrepo = coursrepo;
	}
	@Autowired
	private CoursRepository coursrepo;
	
	
	@CrossOrigin(origins="*")
	@GetMapping(path="/getallCurses")
	public ResponseEntity<List<Cours>> getAllCurses() {
		java.util.List<Cours> courslis = coursrepo.findAll();
		return new ResponseEntity<List<Cours>>(courslis, HttpStatus.ACCEPTED);
	}
	
	@CrossOrigin(origins="*")
	@PutMapping(path="/modifycoursname/{id}/{newname}")
	public ResponseEntity<Cours> modifyName(@PathVariable("id") Long id, @PathVariable("newname") String name){
		Cours course = coursrepo.getById(id);
		course.setIntitule(name);
		coursrepo.save(course);
		return new ResponseEntity<Cours>(course, HttpStatus.ACCEPTED);
		}
	@CrossOrigin(origins="*")
	@PostMapping(path="/addcourse")
	public ResponseEntity<Cours> addCours(@RequestBody Cours newOne){
		Cours newone = coursrepo.save(newOne);
		return new ResponseEntity<Cours>(newone, HttpStatus.ACCEPTED);
	}
	@CrossOrigin(origins="*")
	@DeleteMapping(path="/deletecourse/{id}")
	public ResponseEntity<?> deleteCours(@PathVariable("id") Long id ) {
		coursrepo.deleteById(id);
		return 	new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	@CrossOrigin(origins="*")
	@GetMapping(path="/getcoursesbyensid/{id}")
	public ResponseEntity<Cours> getCoursesByEnseignantId(@PathVariable("id") Long id) {
		Cours returnStatement = coursrepo.findByEsIdEnEquals(id);
		return new ResponseEntity<Cours>(returnStatement, HttpStatus.ACCEPTED);
	}









}
