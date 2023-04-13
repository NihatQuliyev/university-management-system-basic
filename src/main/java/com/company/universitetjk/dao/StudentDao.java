package com.company.universitetjk.dao;

import com.company.universitetjk.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findStudents();
    Student findById(Long id);
    boolean registerStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(Long id);
    List<Student> searchStudent(String name,String email,String country);
}
