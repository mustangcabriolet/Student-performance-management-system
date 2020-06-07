<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<body bgcolor="#D9DFAA">
	<h3>该学生成绩如下：</h3>
	<hr width="700" align="left">
	<table border="1" cellspacing="1" cellpadding="8" width="700">
		<tr>
			<th>课程名</th><th>成绩</th><th>学分</th>
		</tr>
		<s:iterator value="#request.list" var="xscj">
		<tr>
			<td><s:property value="#xscj[2]"/></td>
			<td><s:property value="#xscj[3]"/></td>
			<td><s:property value="#xscj[4]"/></td>
		</tr>
		</s:iterator>
	</table>
	<input type="button" value="返回" onClick="javaScript:history.back()"/>
</body>
</html>
