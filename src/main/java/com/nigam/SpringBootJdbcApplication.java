package com.nigam;

import com.nigam.model.Student;
import com.nigam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootJdbcApplication {

	@Autowired
	StudentService studentService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJdbcApplication.class, args);
		StudentService studentService = context.getBean(StudentService.class);
		
		
		Student emp= new Student();
		emp.setStudentId("1");
		emp.setStudentName("nigam");
		
		Student emp1= new Student();
		emp1.setStudentId("2");
		emp1.setStudentName("Manish");
		
		Student emp2= new Student();
		emp2.setStudentId("3");
		emp2.setStudentName("Manoj");


		studentService.insertStudent(emp);

		List<Student> students = new ArrayList<>();
		students.add(emp1);
		students.add(emp2);
		studentService.insertStudents(students);

		studentService.getAllStudents();

		studentService.getStudentById(emp1.getStudentId());

	}
}