package com.company.universitetjk.dao.impl;

import com.company.universitetjk.config.DatabaseConfig;
import com.company.universitetjk.dao.StudentDao;
import com.company.universitetjk.model.Student;
import com.company.universitetjk.query.StudentQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl extends DatabaseConfig implements StudentDao {
    @Override
    public List<Student> findStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(StudentQuery.FIND_STUDENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                Student student = Student.builder().
                        id(id).
                        name(name).
                        email(email).
                        country(country).
                        build();
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
    @Override
    public Student findById(Long id) {
        try (Connection connection = connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(StudentQuery.FIND_STUDENT_BY_ID);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");

                return Student.builder().
                        id(id).
                        name(name).
                        email(email).
                        country(country).
                        build();
            }
            else {
                throw new NullPointerException("Teacher not found!");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean registerStudent(Student student) {
        try (Connection connection = connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(StudentQuery.CREATE_STUDENT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getCountry());
            int count = preparedStatement.executeUpdate();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean updateStudent(Student student) {
        try (Connection connection = connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(StudentQuery.UPDATE_STUDENT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getCountry());
            preparedStatement.setLong(4, student.getId());
            int count = preparedStatement.executeUpdate();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean deleteStudent(Long id) {
        try (Connection connection = connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(StudentQuery.DELETE_STUDENT);
            preparedStatement.setLong(1, id);
            int count = preparedStatement.executeUpdate();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Student> searchStudent(String studentName ,String studentEmail ,String studentCountry) {
        List<Student> students = new ArrayList<>();
        try (Connection connection = connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(StudentQuery.SEARCH_STUDENT);
            preparedStatement.setString(1, studentCountry);
            preparedStatement.setString(2, studentEmail);
            preparedStatement.setString(3, studentCountry);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet == null || resultSet.wasNull()) {
                throw new NullPointerException("Student not found!");
            }
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                Student student = Student.builder().
                        id(id).
                        name(name).
                        email(email).
                        country(country).
                        build();
                students.add(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
}
