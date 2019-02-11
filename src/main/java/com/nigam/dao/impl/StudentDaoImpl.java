package com.nigam.dao.impl;

import com.nigam.dao.StudentDao;
import com.nigam.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public void insertStudent(Student student) {
        String sql = "INSERT INTO Student " +
                "(studentId, studentName) VALUES (?, ?)";
        jdbcTemplate.update(sql, new Object[]{
                student.getStudentId(), student.getStudentName()
        });

    }

    @Override
    public void insertStudents(final List<Student> students) {
        String sql = "INSERT INTO Student " + "(studentId, studentName) VALUES (?, ?)";
        jdbcTemplate.batchUpdate(sql,
                new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Student student = students.get(i);
                        ps.setString(1, student.getStudentId());
                        ps.setString(2, student.getStudentName());
                    }

                    public int getBatchSize() {
                        return students.size();
                    }
                });

    }

    @Override
    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM Student";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        List<Student> result = new ArrayList<Student>();
        for (Map<String, Object> row : rows) {
            Student student = new Student();
            student.setStudentId((String) row.get("studentId"));
            student.setStudentName((String) row.get("studentName"));
            result.add(student);
        }

        return result;
    }

    @Override
    public Student getStudentById(String studentId) {
        String sql = "SELECT * FROM Student WHERE studentId = ?";
        return (Student) jdbcTemplate.queryForObject(sql, new Object[]{studentId}, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rwNumber) throws SQLException {
                Student student = new Student();
                student.setStudentId(rs.getString("studentId"));
                student.setStudentName(rs.getString("studentName"));
                return student;
            }
        });
    }
}