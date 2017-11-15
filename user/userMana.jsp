<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
        <script language="javascript">
           function userDel(userId)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/userDel.action?userId="+userId;
               }
           }
           
           function cepingAdd(userId)
           {
                   window.location.href="<%=path %>/admin/ceping/cepingAdd.jsp?userId="+userId;
           }
           function cepingMana(userId)
           {
                   window.location.href="<%=path %>/cepingMana.action?userId="+userId;
           }
           
           
            function check1()
		    {
		        if(document.form1.userRealname.value=="")
		        {
		            alert("请输入姓名");
		            return false;
		        }
		        document.form1.submit();
		    }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="10" background="<%=path %>/img/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="5%">序号</td>
					<td width="10%">账号</td>
					<td width="10%">密码</td>
					<td width="10%">姓名</td>
					
					<td width="10%">住址</td>
					<td width="10%">性别</td>
					<td width="10%">电话</td>
					<td width="10%">学员证</td>
					
					<td width="10%">操作</td>
		        </tr>	
				<s:iterator value="#request.userList" id="user" status="sta">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#sta.index+1"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#user.userName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#user.userPw"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#user.userRealname"/>
					</td>
					
					
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#user.userAddress"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#user.userSex"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#user.userTel"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#user.userEmail"/>
					</td>
					<td  bgcolor="#FFFFFF" align="center">
						<input type="button" value="删除" onclick="userDel(<s:property value="#user.userId"/>)"/>
						<input type="button" value="添加测评" onclick="cepingAdd(<s:property value="#user.userId"/>)"/>
						<input type="button" value="测评管理" onclick="cepingMana(<s:property value="#user.userId"/>)"/>
					</td>
				</tr>
				</s:iterator>
			</table>
			
			<br/>
			<form action="<%=path %>/userRes.action" name="form1" method="post">
						<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
							<tr>
								<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
									姓名：
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;
									<input type="text" name="userRealname" style="width: 200px;"/>
								</td>
							</tr>
							<tr>
								<td height="30" align="right" bgcolor="#F9F9F9">
									&nbsp;
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;
									<input type="button" value="查询" onclick="check1();"/>
									<input type="button" value="取消" onclick="closeOpen()"/>
								</td>
							</tr>
						</table>
					</form>
	</body>
</html>
