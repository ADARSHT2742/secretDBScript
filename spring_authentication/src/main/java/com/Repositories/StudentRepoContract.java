package com.Repositories;

import com.Models.Student;

public interface StudentRepoContract {
	public void addStudent(Student s);
	
	public void updateStudent(Student s);
	
	public void findStudent();
	
	public void deleteStudent();
	
	public void clearEntityManager();
	
	public void customQuery();
	
	public void createStoredProc();
	
	public void preparedStatement();
}	
