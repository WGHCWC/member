<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<% 
java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
java.util.Date currentTime = new java.util.Date();
String str_date1 = formatter.format(currentTime);
String str_date2 = currentTime.toString();
out.println(str_date1);
%> 
