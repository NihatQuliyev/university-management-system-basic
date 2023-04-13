package com.company.universitetjk.dao.impl;

import com.company.universitetjk.config.DatabaseConfig;
import com.company.universitetjk.dao.TeacherDao;
import com.company.universitetjk.model.Student;
import com.company.universitetjk.model.Teacher;
import com.company.universitetjk.query.StudentQuery;
import com.company.universitetjk.query.TeacherQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl extends DatabaseConfig implements TeacherDao {

    @Override
    public List<Teacher> findTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        try (Connection connection = connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(TeacherQuery.FIND_TEACHER);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String subject = resultSet.getString("subject");

                Teacher teacher = Teacher.builder().
                        id(id).
                        name(name).
                        email(email).
                        subject(subject).
                        build();

                teachers.add(teacher);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return teachers;
    }

    @Override
    public Teacher findById(Long id) {
        try (Connection connection = connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(TeacherQuery.FIND_TEACHER_BY_ID);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String subject = resultSet.getString("subject");

                return Teacher.builder().
                        id(id).
                        name(name).
                        email(email).
                        subject(subject).
                        build();
            } else {
                throw new NullPointerException("Teacher not found!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean registerTeacher(Teacher teacher) {
        try (Connection connection = connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(TeacherQuery.CREATE_TEACHER);
            preparedStatement.setString(1, teacher.getName());
            preparedStatement.setString(2, teacher.getEmail());
            preparedStatement.setString(3, teacher.getSubject());

            int count = preparedStatement.executeUpdate();

            return count > 0;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        try (Connection connection = connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(TeacherQuery.UPDATE_TEACHER);
            preparedStatement.setString(1, teacher.getName());
            preparedStatement.setString(2, teacher.getEmail());
            preparedStatement.setString(3, teacher.getSubject());
            preparedStatement.setLong(4, teacher.getId());

            int count = preparedStatement.executeUpdate();

            return count > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteTeacher(Long id) {
        try (Connection connection = connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(TeacherQuery.DELETE_TEACHER);
            preparedStatement.setLong(1, id);

            int count = preparedStatement.executeUpdate();

            return count > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Teacher>searchTeacher(String teacherName , String teacherEmail , String teacherSubject) {
        List<Teacher> teachers = new ArrayList<>();
        try (Connection connection = connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(TeacherQuery.SEARCH_TEACHER);
            preparedStatement.setString(1, teacherName);
            preparedStatement.setString(2, teacherEmail);
            preparedStatement.setString(3, teacherSubject);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet == null || resultSet.wasNull()) {
                throw new NullPointerException("Student not found!");
            }
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String subject = resultSet.getString("subject");
                Teacher teacher = Teacher.builder().
                        id(id).
                        name(name).
                        email(email).
                        subject(subject).
                        build();
                teachers.add(teacher);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teachers;
    }
}
