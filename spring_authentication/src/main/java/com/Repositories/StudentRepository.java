package com.Repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Models.Student;

@Repository
public class StudentRepository implements StudentRepoContract {
	@Autowired
	private EntityManager em;
	
	public void addStudent(Student s) {
		EntityTransaction et =em.getTransaction();
		et.begin();
		em.persist(s);
		et.commit();
		System.out.println(s.toString());
		System.out.println("Student added");
	}
	
	public void updateStudent(Student s) {
		EntityTransaction et =em.getTransaction();
		et.begin();
		em.merge(s);
		et.commit();
		System.out.println(s.toString());
		System.out.println("Student updated");
	}
	
	public void findStudent() {
		EntityTransaction et =em.getTransaction();
		et.begin();
		Student s = em.find(Student.class,9);
		et.commit();
		System.out.println(s.toString());
		System.out.println("Student fetched");
	}
	
	public void deleteStudent() {
		EntityTransaction et =em.getTransaction();
		et.begin();
		Student s = em.find(Student.class,10);
		em.remove(s);
		et.commit();
		System.out.println(s.toString());
		System.out.println("Student deleted");
	}
	
	public void clearEntityManager() {
		EntityTransaction et =em.getTransaction();
		et.begin();
		em.clear();
		et.commit();
		System.out.println("Student deleted");
	}
	
	public void customQuery() {
		EntityTransaction et =em.getTransaction();
		et.begin();
//		TypedQuery<Student> tq = em.createQuery("select s from Student s", Student.class);
		int x =em.createNativeQuery("CALL getstudents()").executeUpdate();
//		List<Student> ls = tq.getResultList();
//		System.out.println(ls);
		System.out.println("Rows Updated : "+x);
		et.commit();
		System.out.println("custom Query performed on student entity class");
	}
	
	@Transactional
	public void createStoredProc() {
		EntityTransaction et = em.getTransaction();
		et.begin();
		StoredProcedureQuery spq = em.createStoredProcedureQuery("getstudents");
//        spq.execute();
        spq.executeUpdate();
		et.commit();
		System.out.println("Stored Procedure executed successfully");
		return;
	}
	
	public void preparedStatement() {
		EntityTransaction et = em.getTransaction();
		et.begin();
		TypedQuery<Student> tqs = em.createQuery("select s from Student s where s.id < :sid", Student.class);
		tqs.setParameter("sid",12);
		List<Student> ls = tqs.getResultList();
		System.out.println(ls);
		et.commit();
		System.out.println("Prepared statement executed successfully");
		return;
	}
}
