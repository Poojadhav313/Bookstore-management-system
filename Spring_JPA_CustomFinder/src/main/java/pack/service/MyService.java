package pack.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pack.model.Student;
import pack.repo.MyRepository;

@Service
public class MyService {
	 @Autowired
	    private MyRepository repo;

	    public Optional<Student> getUserByName(String name) {
	        return repo.findByName(name);
	    }

		public List<Student> getUsers() {
			return repo.findAll();
		}

		public Student addUser(Student s) {
			return repo.save(s);
		}
		
		public String deleteUsers() {
			repo.deleteAll();
			return "deleted all";
		}
		
		public String deleteUserById(Long id) {
			repo.deleteById(id);
			return "deleted";
		}
}
