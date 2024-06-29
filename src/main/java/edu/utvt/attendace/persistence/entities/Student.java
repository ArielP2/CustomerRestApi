package edu.utvt.attendace.persistence.entities;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import edu.utvt.attendace.persistence.common.StudentType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "te_students")

public class Student {
	
	@Id
	@Column (length = 10)
	private String id;
	
	@Column (length = 50, nullable = false)
	private String firstName;
	
	@Column (length = 100, nullable = false)
	private String lastName;
	
	@Column (length = 50, nullable = false)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private StudentType type;
	
	@JsonFormat(pattern = "dd/mm/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date birthDate;
	
	@Column(nullable = false, updatable = false)
	@JsonFormat(pattern = "dd/mm/yyyy HH:mm:ss")
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date CreatenOn;
	
	

}
