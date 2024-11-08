package pack.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import pack.model.Student;

@Component
public interface StudentDao {
	List<Student> getAll();
	Student getById(int id);
	
	int save(Student student);
	int update(Student student, int id);
	int delete(int id);
}
