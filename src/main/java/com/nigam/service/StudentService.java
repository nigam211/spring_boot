package com.nigam.service;

import com.nigam.model.Student;

import java.util.List;

public interface StudentService {
	void insertStudent(Student student);
	void insertStudents(List<Student> students);
	void getAllStudents();
	void getStudentById(String studentId);
}