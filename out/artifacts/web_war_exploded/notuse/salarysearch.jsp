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
    
    <title>ͼ�����.jsp' starting page</title>
    
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
  <font face="����">���ʲ�ѯ</font>
  <br>
  </h1>
  <p>��ʱ���ѯ: 
  <select name="combobox1">
		<option selected value="2016-01">1��</option>
		<option value="2016-02">2��</option>
		<option value="2016-03">3��</option>
		<option value="2016-04">4��</option>
		<option value="2016-05">5��</option>
		<option value="2016-06">6��</option>
		<option value="2016-07">7��</option>
		<option value="2016-08">8��</option>
		<option value="2016-09">9��</option>
		<option value="2016-10">10��</option>
		<option value="2016-11">11��</option>
		<option value="2016-12">12��</option>
  </select>
        <br>
       
  </p>
  
  <p> <input type="submit" value="��ѯ" name="��ѯ">&nbsp;&nbsp;&nbsp;&nbsp; 
  <input type="reset" value="����" name="reset">&nbsp;</p>
  </form>
 </center> </body>
</html>
