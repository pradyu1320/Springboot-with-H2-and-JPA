package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	private StudentRepository repo;
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return repo.findAll();
	}
	@PostMapping("/student")
	public Student createStudent(@Valid @RequestBody Student student) {
		return repo.save(student);
	}
	@DeleteMapping("/student/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable(value="id")long id){
		Student student = repo.findById(id).orElseThrow(null);
		repo.delete(student);
		return ResponseEntity.ok().build();
	}
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable(value="id")long id) {
		return repo.findById(id).orElseThrow(null);
	}
	@PutMapping("/student/{id}")
	public Student updateStudent(@PathVariable(value="id")long id,@Valid @RequestBody Student std) {		
		Student student = repo.findById(id).orElseThrow(null);
		student.setName(std.getName());
		student.setPassportNumber(std.getPassportNumber());
		Student updated = repo.save(student);
		return updated;
	}
}
