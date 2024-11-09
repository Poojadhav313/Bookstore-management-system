package pack.controll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pack.model.Student;
import pack.service.MyService;

@RestController
public class MyController {

    @Autowired
    private MyService serv;

    @GetMapping("/users/{name}")
    public Optional<Student> getUserByName(@PathVariable String name) {
        return serv.getUserByName(name);
    }
    
    @GetMapping("/users")
    public List<Student> getUsers()
    {
    	return serv.getUsers();
    }
    
    @PostMapping("/users")
    public Student addUser(@RequestBody Student s)
    {
    	return serv.addUser(s);
    }
    
    @DeleteMapping("/users")
    public String deleteUsers()
    {
    	return serv.deleteUsers();
    }
    
    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable Long id)
    {
    	return serv.deleteUserById(id);
    }
}
