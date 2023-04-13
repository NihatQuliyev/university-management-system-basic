package com.company.universitetjk.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TeacherService {

    void findTeacher(HttpServletResponse resp , HttpServletRequest req);
    void editForm(HttpServletResponse resp , HttpServletRequest req);
    void newForm(HttpServletResponse resp , HttpServletRequest req);
    void registerTeacher(HttpServletResponse resp , HttpServletRequest req);
    void updateTeacher(HttpServletResponse resp , HttpServletRequest req);
    void deleteTeacher( HttpServletRequest req,HttpServletResponse resp );
    void searchTeacher(HttpServletResponse resp, HttpServletRequest req);

}
