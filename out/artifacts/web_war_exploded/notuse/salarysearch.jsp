<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/header.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图书查找.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body background="images/001.jpg">
  <%@ include file="/SiteNavigator.jsp"%>
  <center>
  <form method="post" name="book" action="<%=basePath%>Searchservlet">
  <h1 align="center">
  <font face="宋体">工资查询</font>
  <br>
  </h1>
  <p>按时间查询: 
  <select name="combobox1">
		<option selected value="2016-01">1月</option>
		<option value="2016-02">2月</option>
		<option value="2016-03">3月</option>
		<option value="2016-04">4月</option>
		<option value="2016-05">5月</option>
		<option value="2016-06">6月</option>
		<option value="2016-07">7月</option>
		<option value="2016-08">8月</option>
		<option value="2016-09">9月</option>
		<option value="2016-10">10月</option>
		<option value="2016-11">11月</option>
		<option value="2016-12">12月</option>
  </select>
        <br>
       
  </p>
  
  <p> <input type="submit" value="查询" name="查询">&nbsp;&nbsp;&nbsp;&nbsp; 
  <input type="reset" value="重置" name="reset">&nbsp;</p>
  </form>
 </center> </body>
</html>
