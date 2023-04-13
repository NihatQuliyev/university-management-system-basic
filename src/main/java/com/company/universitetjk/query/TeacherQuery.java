package com.company.universitetjk.query;

public class TeacherQuery {

    public static final String FIND_TEACHER = "SELECT * FROM teacher WHERE status=1";
    public static final String FIND_TEACHER_BY_ID = "SELECT * FROM teacher WHERE id=? and status=1";
    public static final String CREATE_TEACHER = "INSERT INTO teacher(name, email, subject) VALUES (?,?,?)";
    public static final String UPDATE_TEACHER = "UPDATE teacher SET name = ?,email = ?,subject = ? where id = ? and  status = 1";
    public static final String DELETE_TEACHER = "UPDATE teacher SET status  = 0 where id = ?";

    public static final String SEARCH_TEACHER = "SELECT * FROM teacher WHERE status= 1 and (name LIKE ? OR subject LIKE ? OR email LIKE ?)";

}
