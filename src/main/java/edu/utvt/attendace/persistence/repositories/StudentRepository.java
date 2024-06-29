package edu.utvt.attendace.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.utvt.attendace.persistence.entities.Student;

public interface StudentRepository  extends JpaRepository<Student, String>  {

}
