package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.RegistrationRepository;
import com.example.demo.model.Registration;
import com.example.demo.request.EditProfile;
import com.example.demo.request.SignupForm;

@RestController
@RequestMapping("/ap")
public class MainController {

	@Autowired
	RegistrationRepository reee;
	
	@PostMapping("/postreg")
	public Registration rr(@RequestBody SignupForm ss) {
		Registration _tt = reee.save(new Registration(ss.getFirstname(), ss.getLastname(), ss.getEmail(), ss.getPassword()));
		return _tt;
	}
	
	
	@GetMapping("/getreg")
	
	public List<Registration> retri(){
		return reee.findAll();
	}
	
	@GetMapping("/getreg/{id}")
	
	public Optional<Registration> retri( @PathVariable long id){
		return reee.findById(id);
	}
	
	@DeleteMapping("/getreg/{id}")
	public void deleteById(@PathVariable long id) {
		reee.deleteById(id);
	}
	
	@PutMapping("/getreg/{id}")
	public ResponseEntity<String> creteUp(@RequestBody EditProfile es, @PathVariable ("id") long id){
		Optional<Registration> r = reee.findById(id);
		if(r.isPresent())
		{
			Registration j = r.get();
			j.setEmail(es.getEmail());
			j.setPassword(es.getPassword());
			reee.save(j);
			return ResponseEntity.ok().body("added");
		}
		return ResponseEntity.ok().body("not added");
	}
	
	
	
}
