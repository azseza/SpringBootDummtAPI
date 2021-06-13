package azs.eza.controllers;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ValueRange;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import azs.eza.entities.Seance;
import azs.eza.repository.SeanceRepository;

@RestController
public class SeanceController {

	@Autowired
	SeanceRepository seanceRepo;
	
	public SeanceController(SeanceRepository seanceRepo) {
		this.seanceRepo = seanceRepo;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/addSeance")
	public ResponseEntity<?> addSeance(@RequestBody Seance seance){
		seanceRepo.save(seance);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	/*
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/getSeanceOfToday")
	public ResponseEntity<List<Seance>> getSeanceOfToday(){
		 LocalDate d = LocalDate.now();
		 ValueRange r = d.range(ChronoField.HOUR_OF_DAY);
		 
	}
	*/
}
