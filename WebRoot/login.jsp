<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>学生成绩管理系统</title>
</head>
<body bgcolor="#D9DFAA">
<s:form action="login" method="post" theme="simple">
<table>
	<caption>用户登录</caption>
	<tr>
		<td>
			学号：<s:textfield name="dl.xh" size="20"/>
		</td>
	</tr>
	<tr>
		<td>
			口令：<s:password name="dl.kl" size="21"/>
		</td>
	</tr>
	<tr>
		<td align="right">
			<s:submit value="登录"/>
			<s:reset value="重置"/>
		</td>
	</tr>
</table>
</s:form>
</body>
</html>
