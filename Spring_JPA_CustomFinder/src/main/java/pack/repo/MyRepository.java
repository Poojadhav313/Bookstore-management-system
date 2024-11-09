package pack.repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pack.model.Student;

public interface MyRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByName(String name);
    
    List<Student> findAll();
    Student save(Student s);
    void deleteAll();
    void deleteById(Long id);
}
