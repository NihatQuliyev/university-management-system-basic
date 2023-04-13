package com.company.universitetjk.query;

public class StudentQuery {

    public static final String FIND_STUDENT = "SELECT * FROM student WHERE status=1";
    public static final String FIND_STUDENT_BY_ID =  "SELECT * FROM student WHERE id=? and status=1";
    public static final String CREATE_STUDENT = "INSERT INTO student(name, email, country) VALUES (?,?,?)";
    public static final String UPDATE_STUDENT = "UPDATE student SET name = ?,email = ?,country = ? where id = ? and  status = 1";
    public static final String DELETE_STUDENT = "UPDATE student SET status  = 0 where id = ?";
    public static final String SEARCH_STUDENT = "SELECT * FROM student WHERE status= 1 and (name LIKE ? OR country LIKE ? OR email LIKE ?)";


}
