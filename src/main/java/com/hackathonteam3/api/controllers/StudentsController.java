package com.hackathonteam3.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathonteam3.api.models.Student;
import com.hackathonteam3.api.request.StudentRequest;
import com.hackathonteam3.api.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentsController {
	
	@Autowired
	StudentService studentService;
	
	//Endpoint para crear estudiante
	@PostMapping("/")
	public Optional<Student> createStudent( @RequestBody StudentRequest sRequest) {
		return studentService.createStudentService(sRequest);
	}
	
	//Endpoint para ver todos los estudiantes
	@GetMapping("/")
	public List<Student> readStudents() {
		return studentService.getStudentsService();
	}
	
	//Endpoint para ver un estudiante
	@GetMapping("/{id}")
	public Optional<Student> readStudent(@PathVariable Long id) {
		return studentService.getStudentService(id);
	}
	
	//Endpoint para actualizar un estudiante por Id
	@PatchMapping("/{id}")
	public Student updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
		return studentService.updateStudentService(id,student);
	}
	
	//Endpoint para eliminar un estudiante por Id
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable("id") Long id) {
		studentService.deleteStudentService(id);
	}
}
