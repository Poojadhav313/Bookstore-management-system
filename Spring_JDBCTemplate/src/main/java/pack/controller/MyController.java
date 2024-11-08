package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pack.dao.StudentDaoImplementation;
import pack.model.Student;

@RestController
public class MyController 
{
	@Autowired
	StudentDaoImplementation dao = new StudentDaoImplementation();
	
	@GetMapping("/stud")
	public List<Student> getAllStudents()
	{
		return dao.getAll();
	}
	
	@GetMapping("/stud/{id}")
	public Student getByIdStudent(@PathVariable int id)
	{
		return dao.getById(id);
	}
	
	@PostMapping("/stud")
	public String saveStudent(@RequestBody Student s)
	{
		return dao.save(s) + " rows saved to database";
	}
	
	@DeleteMapping("/stud/{id}")
	public String deleteStudent(@PathVariable int id) 
	{
		return dao.delete(id)  +" row deleted";
	}
	
	@PutMapping("/stud/{id}")
	public String updateStudent(@RequestBody Student s, @PathVariable int id)
	{
		return dao.update(s,id) + " row updated";
	}
}
