<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head></head>
<body bgcolor="#D9DFAA">
	<table border="1" cellspacing="1" cellpadding="8" width="700">
		<tr align="center" bgcolor="silver">
			<th>学号</th><th>姓名</th><th>性别</th><th>专业</th><th>出生时间</th><th>总学分</th><th>详细信息</th><th>操作</th><th>操作</th>
		</tr>
		<s:iterator value="#request.list" var="xs">
		<tr>
			<td><s:property value="#xs.xh"/></td>
			<td><s:property value="#xs.xm"/></td>
			<td>
				<s:if test="#xs.xb==1">男</s:if>
				<s:else>女</s:else>
			</td>
			<td><s:property value="#xs.zyb.zym"/></td>
			<td><s:property value="#xs.cssj"/></td>
			<td><s:property value="#xs.zxf"/></td>
			<td>
				<a href="findXs.action?xs.xh=<s:property value="#xs.xh"/>">详细信息</a>
			</td>
			<td>
				<a href="deleteXs.action?xs.xh=<s:property value="#xs.xh"/>" onClick="if(!confirm('确定删除该生信息吗？'))return false;else return true;">删除</a>
			</td>
			<td>
				<a href="updateXsView.action?xs.xh=<s:property value="#xs.xh"/>">修改</a>
			</td>
		</tr>
		</s:iterator>
		<tr>
			<s:set var="page" value="#request.page"></s:set>
			<s:if test="#page.hasFirst">
				<s:a href="xsInfo.action?pageNow=1">首页</s:a>
			</s:if>
			<s:if test="#page.hasPre">
				<a href="xsInfo.action?pageNow=<s:property value="#page.pageNow-1"/>">上一页</a>
			</s:if>
			<s:if test="#page.hasNext">
				<a href="xsInfo.action?pageNow=<s:property value="#page.pageNow+1"/>">下一页</a>
			</s:if>
			<s:if test="#page.hasLast">
				<a href="xsInfo.action?pageNow=<s:property value="#page.totalPage"/>">尾页</a>
			</s:if>
		</tr>
	</table>
</body>
</html>
