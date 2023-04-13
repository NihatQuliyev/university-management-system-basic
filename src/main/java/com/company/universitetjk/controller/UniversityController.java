package com.company.universitetjk.controller;

import com.company.universitetjk.service.StudentService;
import com.company.universitetjk.service.TeacherService;
import com.company.universitetjk.service.impl.StudentServiceImpl;
import com.company.universitetjk.service.impl.TeacherServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/", name = "UserServlet")
public class UniversityController extends HttpServlet {

    private StudentService studentService;
    private TeacherService teacherService;

    public void init() {
        this.studentService = new StudentServiceImpl();
        this.teacherService = new TeacherServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = req.getServletPath();

        System.out.println(path);
        if (path.startsWith("/editTeacher")) {
            teacherService.editForm(resp, req);
        }
        else if (path.startsWith("/editStudent")){
            studentService.editForm(resp, req);
        }
        switch (path) {
            case "/listStudent":
                studentService.findStudent(resp, req);
                break;
            case "/searchStudent":
                studentService.searchStudent(resp,req);
                break;
            case "/searchTeacher":
                teacherService.searchTeacher(resp,req);
                break;
            case "/listTeacher":
                teacherService.findTeacher(resp, req);
                break;
            case "/deleteTeacher":
                teacherService.deleteTeacher(req,resp);
                break;
            case "/deleteStudent":
                studentService.deleteStudent(resp,req);
                break;
            default:
                System.out.println("Invalid option");
                resp.getWriter().write("Invalid option!");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Azerbaijan");
        String path = req.getServletPath();
        System.out.println(path);
        switch (path) {
            case "/newStudent":
                studentService.newForm(resp, req);
                break;
            case "/registerStudent":
                studentService.register(resp, req);
                break;
            case "/newTeacher":
                teacherService.newForm(resp, req);
                break;
            case "/registerTeacher":
                teacherService.registerTeacher(resp, req);
                break;

            case "/updateTeacher":
                teacherService.updateTeacher(resp, req);
                break;
            case "/updateStudent":
                studentService.updateStudent(resp, req);
                break;
            default:
                System.out.println("Invalid option");
                resp.getWriter().write("Invalid option!");
        }
    }
}