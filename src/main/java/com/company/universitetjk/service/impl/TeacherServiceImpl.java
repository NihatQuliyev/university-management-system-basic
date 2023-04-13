package com.company.universitetjk.service.impl;

import com.company.universitetjk.dao.TeacherDao;
import com.company.universitetjk.dao.impl.TeacherDaoImpl;
import com.company.universitetjk.model.Teacher;
import com.company.universitetjk.service.TeacherService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    private TeacherDao teacherDao;
    public TeacherServiceImpl(){
        teacherDao = new TeacherDaoImpl();
    }

    @Override
    public void findTeacher(HttpServletResponse resp, HttpServletRequest req) {
        List<Teacher> teacherList = teacherDao.findTeachers();
        req.setAttribute("teacherList", teacherList);
        System.out.println(teacherList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("teacher-list.jsp");
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
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("teacher-form.jsp");
        Long id = Long.parseLong(req.getParameter("id"));
        Teacher teacher = teacherDao.findById(id);
        req.setAttribute("teacher", teacher);

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
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("teacher-form.jsp");
        if(!resp.isCommitted()){
            try {
                requestDispatcher.forward(req,resp);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void registerTeacher(HttpServletResponse resp, HttpServletRequest req) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String subject = req.getParameter("subject");
        teacherDao.registerTeacher(Teacher.builder().
                name(name).
                email(email).
                subject(subject).
                build());
        try {
            resp.sendRedirect("listTeacher");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateTeacher(HttpServletResponse resp, HttpServletRequest req) {
        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String subject = req.getParameter("subject");
        teacherDao.updateTeacher(Teacher.builder()
                .id(id)
                .name(name)
                .email(email)
                .subject(subject)
                .build());
        try {
            resp.sendRedirect("listTeacher");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteTeacher(HttpServletRequest req, HttpServletResponse resp) {
        Long id = Long.parseLong(req.getParameter("id"));
        teacherDao.deleteTeacher(id);

        RequestDispatcher dispatcher = req.getRequestDispatcher("teacher-list.jsp");
        try {
            resp.sendRedirect("listTeacher");
            if (!resp.isCommitted()) {
                dispatcher.forward(req, resp);
            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void searchTeacher(HttpServletResponse resp, HttpServletRequest req) {
        String name = req.getParameter("sct");
        String email = req.getParameter("sct");
        String country = req.getParameter("sct");
        List<Teacher> teacherList = teacherDao.searchTeacher(name,email,country);
        req.setAttribute("teacherList", teacherList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("teacher-list.jsp");
        try {
            if (!resp.isCommitted()) {
                requestDispatcher.forward(req, resp);
            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}