<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head></head>
<body bgcolor="#D9DFAA">
	<s:set var="dl" value="#session['dl']"/>
	学号<s:property value="#dl.xh"/>登录成功！欢迎使用学生成绩管理系统。
</body>
</html>
