package com.utils;

public class SQL {
    public static final String checkEmail = "select * from MemberInfo where mail =?";
    public static final String serachAllMember = "select * from MemberInfo ;";
    public static final String insertMember = "insert into MemberInfo set " +
            "level=?," +
            "name=?," +
            "address=?," +
            "background=?," +
            "mail=?," +
            "password=?," +
            "introduce=?";
    public static final String serachAllMeeting = "select * from Meeting ;";
    public static final String insertMeeting = "insert into Meeting set id=?,name=?,address=?,mail=?,introduce=?,status=?;";

}