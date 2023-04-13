package com.company.universitetjk.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface StudentService {

    void findStudent(HttpServletResponse resp , HttpServletRequest req);
    void editForm(HttpServletResponse resp , HttpServletRequest req);
    void newForm(HttpServletResponse resp , HttpServletRequest req);
    void register(HttpServletResponse resp , HttpServletRequest req);
    void updateStudent(HttpServletResponse resp , HttpServletRequest req);
    void deleteStudent(HttpServletResponse resp , HttpServletRequest req);
    void searchStudent(HttpServletResponse resp, HttpServletRequest req);



}
