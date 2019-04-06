package com.utils;

public class SQL {
    public static final String updateMemberInfo = "update MemberInfo  set " +
            "level=? ," +
            "name=?," +
            "address=?, " +
            "background=?," +
            "introduce=?, " +
            "password=?" +
            "where mail=?;";

    public static final String updateLevel = "update MemberInfo  set level=? where id=?";

    public static final String checkEmail = "select * from MemberInfo where mail =?";
    public static final String searchAllMember = "select * from MemberInfo ;";
    public static final String insertMember = "insert into MemberInfo set " +
            "level=?," +
            "name=?," +
            "address=?," +
            "background=?," +
            "password=?," +
            "introduce=?" +
            "mail=?";

    /**
     * meet
     */

    public static final String searchAllMeeting = "select * from Meeting ;";
    public static final String insertMeeting = "insert into Meeting set " +
            "id=?," +
            "name=?," +
            "address=?," +
            "mail=?," +
            "introduce=?," +
            "status=?;";
    public static final String updateMeetById = "update Meeting  set status=? where id=?;";


    /**
     * message
     */
    public static final String insertMessage = "insert into Message set " +
            "id=?," +
            "title=?," +
            "author=?," +
            "main=?," +
            "status=?;";
    public static final String searchAllMessage = "select * from Message ;";
    public static final String delMessage = "DELETE FROM Message WHERE id=?;";


    /**
     * article
     */

    public static final String insertArticle = "insert into Article set id=?,times=?,title=?,author=?,main=?,status=?;";
    public static final String searchAllArticle = "select * from Article ;";
    public static final String updateVoteArticle = "update Article  set times=times+1 where id=?";
    public static final String delArticle = "DELETE FROM Article WHERE id=?;";


}