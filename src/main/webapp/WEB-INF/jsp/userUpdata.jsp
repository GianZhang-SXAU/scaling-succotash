<%--
  Created by IntelliJ IDEA.
  User: gian
  Date: 2023/11/30
  Time: 7:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="c" %>
<html>
<head>
    <title>信息修改</title>

</head>
<body bgcolor="yellow">
<div align="center">
    <h1 style="color: red">防控疫情，人人有责</h1>
    <p style="font-size: larger">欢迎来到信息修改页面</p>
    <h1 style="color: red">${waring}</h1>
</div>
<div align="center">
    <%--@elvariable id="user" type="com"--%>
    <c:form method="post" modelAttribute="user" action="${pageContext.request.contextPath}/user/updatesave">
        <fieldset>
            <legend>用户信息录入</legend>
            <table>
                <tr>
                    <td>用户名：</td>
                    <td><c:input path="name"/></td>
                </tr>
                <tr>
                    <td>性别：</td>
                    <td>
                        <c:radiobutton path="sex" value="男"/>男
                        <c:radiobutton path="sex" value="女"/>女
                    </td>
                </tr>
                <tr>
                    <td>健康码：</td>
                    <td>
                        <c:radiobuttons path="health" items="${health}"/>
                    </td>
                </tr>
                <tr>
                    <td>爱好：</td>
                    <td>
                        <c:checkboxes path="hobby" items="${hobby}"/>
                    </td>
                </tr>
                <tr>
                    <td>接触人员</td>
                    <td>
                        <c:checkboxes path="people" items="${people}"/>
                    </td>
                </tr>
                <tr>
                    <td>居住地</td>
                    <td>
                        <c:select path="location">
                            <option>请选择居住地</option>
                            <c:options items="${location}"/>
                        </c:select>
                    </td>
                </tr>
                <tr>
                    <td>职业</td>
                    <td>
                        <c:select path="work">
                            <option>请选择居住地</option>
                            <c:options items="${work}"/>
                        </c:select>
                    </td>
                </tr>
                <tr>
                    <td>个人描述</td>
                    <td><c:textarea path="other"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input id="submit" type="submit" value="确认修改并查看结果">
                        <input id="reset" type="reset" value="撤销提交的信息">
                    </td>
                </tr>
            </table>
        </fieldset>
    </c:form>
</div>
</body>
</html>
