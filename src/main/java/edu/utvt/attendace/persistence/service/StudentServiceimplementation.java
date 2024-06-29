package edu.utvt.attendace.persistence.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.utvt.attendace.persistence.entities.Student;
import edu.utvt.attendace.persistence.repositories.StudentRepository;

@Service

public class StudentServiceimplementation implements StudentService {
	
	@Autowired
	public StudentRepository studentrepository;

	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		return this.studentrepository.save(student);
	}
	

	@Override
	public Student update(String id, Student student) {
		// TODO Auto-generated method stub
		Optional <Student> studentOptional = null; 
		
		studentOptional = this.studentrepository.findById(id);
		
		if (studentOptional.isPresent()) {
			
			studentOptional.get().setId(student.getId());
			studentOptional.get().setFirstName(student.getFirstName());
			studentOptional.get().setLastName(student.getLastName());
			studentOptional.get().setEmail(student.getEmail());
			studentOptional.get().setType(student.getType());
			studentOptional.get().setBirthDate(student.getBirthDate());
			
			this.studentrepository.save(studentOptional.get());
			
		}
		return studentOptional.orElseThrow();
	}

	
	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return this.studentrepository.findAll();
	}
	

	@Override
	public Optional<Student> findById(String id) {
		return this.studentrepository.findById(id);
	}

	@Override
	public ResponseEntity<Student> deleteById() {
		
		
		Optional <Student> studentOptional = null;
		ResponseEntity<Student> responseEntity = null;
		
		studentOptional = this.studentrepository.findById(id);
		
		
		if (studentOptional.isPresent()) {
			
			this.studentrepository.delete(	studentOptional.get());
			
			responseEntity = ResponseEntity.noContent().build();
			
		}else {
			responseEntity = ResponseEntity.notFound().build();
			
		}
			
		
		return responseEntity;
	}

}
