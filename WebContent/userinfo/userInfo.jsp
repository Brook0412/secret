<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
	

	<script language="javascript">
		    function check1()
		    {
		        if(document.form1.userName.value=="")
		        {
		            alert("请输入账号");
		            return false;
		        }
		        if(document.form1.userPw.value=="")
		        {
		            alert("请输入密码");
		            return false;
		        }
		        document.form1.submit();
		    }
        </script>
	
	
  </head>
  
<body>

                     <form action="<%=path %>/userEdit.action" name="form1" method="post">
						<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
							<tr>
								<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
									账号：
								</td>
								<td width="80%" bgcolor="#FFFFFF">
									&nbsp;
									<input type="text" name="userName" style="width: 200px;" value="${sessionScope.user.userName }"/>
									(账号只读)
								</td>
							</tr>
							<tr>
								<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
									密码：
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;
									<input type="password" name="userPw" style="width: 200px;" value="${sessionScope.user.userPw }"/>
								</td>
							</tr>
							<tr>
								<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
									姓名：
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;
									<input type="text" name="userRealname" style="width: 200px;" value="${sessionScope.user.userRealname }"/>
								</td>
							</tr>
							<tr>
								<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
									性别：
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;
									<input type="radio" name="userSex" value="男" checked="checked"/>男
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="userSex" value="女"/>女
								</td>
							</tr>
							<tr>
								<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
									住址：
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;
									<input type="text" name="userAddress" style="width: 200px;" value="${sessionScope.user.userAddress }"/>
								</td>
							</tr>
							
							<tr>
								<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
									电话：
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;
									<input type="text" name="userTel" style="width: 200px;" value="${sessionScope.user.userTel }"/>
								</td>
							</tr>
							<tr>
								<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
									邮箱：
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;
									<input type="text" name="userEmail" style="width: 200px;" value="${sessionScope.user.userEmail }"/>
								</td>
							</tr>
							<tr>
								<td height="30" align="right" bgcolor="#F9F9F9">
									&nbsp;
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;
									<input type="hidden" name="userId" value="${sessionScope.user.userId }">
									<input type="button" value="确定" onclick="check1();"/>
									<input type="button" value="取消" onclick="closeOpen()"/>
								</td>
							</tr>
						</table>
					</form>
					
</body>
</html>
