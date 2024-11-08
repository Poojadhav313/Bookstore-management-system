package pack.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pack.model.*;

@Repository
public class StudentDaoImplementation 
{
	
	@Autowired
	JdbcTemplate t;
	
	public List<Student> getAll()
	{
		return t.query("select * from student", new StudentRowMapper());
	}
	
	public Student getById(int id)
	{
		return t.queryForObject("select * from student where id = ?", new StudentRowMapper(), id);
	}
	
	public int save(Student s) 
	{
		return t.update("insert into student (id, name) values(?,?)" ,new Object[] {s.getId(), s.getName()});
	}
	
	public int delete(int id) 
	{
		return t.update("delete from student where id=?", id);
	}
	
	public int update(Student s, int id) {
		return t.update("update student set name = ? where id = ?", s.getName(), id);
	}
}
