package edu.utvt.attendace.controller;

import java.util.List;

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

import edu.utvt.attendace.persistence.entities.Student;
import edu.utvt.attendace.persistence.service.StudentService;


@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public List<Student> get() {
		return this.studentService.getAll();
	}
	
	@PostMapping
	public ResponseEntity<Student> save(@RequestBody Student student) {
		return ResponseEntity.created(null).body(this.studentService.save(student));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> update(@PathVariable("id") String id, @RequestBody Student student) {
		return ResponseEntity.ok(this.studentService.update(id, student));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Student> delete(@PathVariable("id") String studentId) {
		return this.studentService.deleteById();
	}
	
	
	
}
