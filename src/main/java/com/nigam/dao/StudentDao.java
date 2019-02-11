package com.nigam.dao;

import com.nigam.model.Student;

import java.util.List;

public interface StudentDao {
	void insertStudent(Student student);
	void insertStudents(List<Student> students);
	List<Student> getAllStudents();
	Student getStudentById(String studentId);
}