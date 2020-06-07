<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head></head>
<body bgcolor="#D9DFAA">
	<h3>该学生信息如下：</h3>
	<s:set var="xs" value="#request.xs"></s:set>
	<s:form action="xsInfo" method="post">
		<table border="0" cellpadding="5">
			<tr>
				<td>学号：</td>
				<td width="100">
					<s:property value="#xs.xh"/>
				</td>
				<td rowspan="7">
					<img src="getImage.action?xs.xh=<s:property value="#xs.xh"/>" width="120" height="150">
				</td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td width="100">
					<s:property value="#xs.xm"/>
				</td>
			</tr>
			<tr>
				<td>性别：</td>
				<td width="100">
					<s:if test="#xs.xb==1">男</s:if>
					<s:else>女</s:else>
				</td>
			</tr>
			<tr>
				<td>专业：</td>
				<td width="100">
					<s:property value="#xs.zyb.zym"/>
				</td>
			</tr>
			<tr>
				<td>出生时间：</td>
				<td width="100">
					<s:property value="#xs.cssj"/>
				</td>
			</tr>
			<tr>
				<td>总学分</td>
				<td width="100">
					<s:property value="#xs.zxf"/>
				</td>
			</tr>
			<tr>
				<td>备注</td>
				<td width="100">
					<s:property value="#xs.bz"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<s:submit value="返回"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>
