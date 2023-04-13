package com.company.universitetjk.dao;

import com.company.universitetjk.model.Student;
import com.company.universitetjk.model.Teacher;
import java.util.List;

public interface TeacherDao {

    List<Teacher> findTeachers();
    Teacher findById(Long id);
    boolean registerTeacher(Teacher student);
    boolean updateTeacher(Teacher student);
    boolean deleteTeacher(Long id);
    List<Teacher>searchTeacher(String name , String email , String subject);
}
