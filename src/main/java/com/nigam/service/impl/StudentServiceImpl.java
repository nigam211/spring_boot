package com.nigam.service.impl;

import com.nigam.dao.StudentDao;
import com.nigam.model.Student;
import com.nigam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;


    @Override
    public void insertStudent(Student student) {

        studentDao.insertStudent(student);
    }

    @Override
    public void insertStudents(List<Student> students) {

        studentDao.insertStudents(students);
    }

    @Override
    public void getAllStudents() {
        List<Student> students = studentDao.getAllStudents();
        for (Student student : students) {
            System.out.println(student.toString());
        }

    }

    @Override
    public void getStudentById(String studentId) {
        Student student = studentDao.getStudentById(studentId);
        System.out.println(student);

    }
}