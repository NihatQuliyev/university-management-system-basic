package com.company.universitetjk.service.impl;

import com.company.universitetjk.dao.StudentDao;
import com.company.universitetjk.dao.impl.StudentDaoImpl;
import com.company.universitetjk.model.Student;
import com.company.universitetjk.service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;
    public StudentServiceImpl(){
        studentDao = new StudentDaoImpl();
    }

    @Override
    public void findStudent(HttpServletResponse resp, HttpServletRequest req) {
        List<Student> studentList = studentDao.findStudents();
        req.setAttribute("studentList", studentList);
        System.out.println(studentList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("student-list.jsp");
        try {
            if (!resp.isCommitted()) {
                requestDispatcher.forward(req, resp);
            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editForm(HttpServletResponse resp, HttpServletRequest req) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("student-form.jsp");
        Long id = Long.parseLong(req.getParameter("id"));
        Student student = studentDao.findById(id);
        req.setAttribute("student", student);

        if(!resp.isCommitted()){
            try {
                requestDispatcher.forward(req,resp);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void newForm(HttpServletResponse resp, HttpServletRequest req) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("student-form.jsp");
        if(!resp.isCommitted()){
            try {
                requestDispatcher.forward(req,resp);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void register(HttpServletResponse resp, HttpServletRequest req) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        studentDao.registerStudent(Student.builder().
                name(name).
                email(email).
                country(country).
                build());
        try {
            resp.sendRedirect("listStudent");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStudent(HttpServletResponse resp, HttpServletRequest req) {
        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        studentDao.updateStudent(Student.builder()
                .id(id)
                .name(name)
                .email(email)
                .country(country)
                .build());
        try {
            resp.sendRedirect("listStudent");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteStudent(HttpServletResponse resp, HttpServletRequest req) {
        Long id = Long.parseLong(req.getParameter("id"));
        studentDao.deleteStudent(id);

        RequestDispatcher dispatcher = req.getRequestDispatcher("student-list.jsp");
        try {
            resp.sendRedirect("listStudent");
            if (!resp.isCommitted()) {
                dispatcher.forward(req, resp);
            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void searchStudent(HttpServletResponse resp, HttpServletRequest req) {
        String name = req.getParameter("sc");
        String email = req.getParameter("sc");
        String country = req.getParameter("sc");
        List<Student> studentList = studentDao.searchStudent(name,email,country);
        req.setAttribute("studentList", studentList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("student-list.jsp");
        try {
            if (!resp.isCommitted()) {
                requestDispatcher.forward(req, resp);
            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}