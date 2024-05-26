package com.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Models.Student;
import com.Repositories.StudentRepoContract;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentRepoContract src;
	
	@RequestMapping(value="/add")
	public String add() {
		Student s = new Student();
		s.setName("adarsh");
		s.setClassname("btech");
		src.addStudent(s);
		return "fgpassword";
	}
	
	@RequestMapping(value="/update")
	public String update() {
		Student s = new Student();
		s.setName("adsfasdfadsffad");
		s.setClassname("mbbs");
		s.setId(9);
		src.updateStudent(s);
		return "fgpassword";
	}
	
	@RequestMapping(value="/find")
	public String get() {
		src.findStudent();
		return "fgpassword";
	}
	
	@RequestMapping(value="/delete")
	public String delete() {
		src.deleteStudent();
		return "fgpassword";
	}
	
	@RequestMapping(value="/clear")
	public String clear() {
		src.clearEntityManager(); // any entitiy instance not flushed to db will be removed / cleared
		return "fgpassword";
	}
	
	@RequestMapping(value="/custom")
	public String custom() {
		src.customQuery(); 
		return "fgpassword";
	}
	
	@RequestMapping(value="/proc")
	public String proc() {
		src.createStoredProc(); 
		return "fgpassword";
	}
	
	@RequestMapping(value="/prepare")
	public String prepare() {
		src.preparedStatement(); 
		return "fgpassword";
	}
}
