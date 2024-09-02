<%--
  Created by IntelliJ IDEA.
  User: gian
  Date: 2023/11/30
  Time: 7:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script>
        function deleteUser(name) {
            const xhr = new XMLHttpRequest();
            xhr.open("GET", "${pageContext.request.contextPath}/user/delete?name="+name, true);
            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    alert("删除成功");
                    location.reload();
                }
            };
            xhr.send();
        }

        function UpdateUser(name) {
            window.location.href = "${pageContext.request.contextPath}/user/update?name=" + name;
        }
    </script>
</head>
<body bgcolor="aqua">
<div align="center">
<h1>欢迎来到用户信息展示页面</h1>
</div>
<a href="${pageContext.request.contextPath}/user/input">点击继续添加用户</a>
<div align="center">
    <fieldset>
        <legend>成员列表</legend>

        <table border="1px" bgcolor="yellow" align="center">
            <tr>
                <th>用户名</th>
                <th>性别</th>
                <th>健康码</th>
                <th>爱好</th>
                <th>接触人员</th>
                <th>居住地</th>
                <th>职业</th>
                <th>个人描述</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.name}</td>
                    <td>${user.sex}</td>
                    <td>${user.health}</td>
                    <td>
                        <c:forEach items="${user.hobby}" var="hobby">
                            ${hobby}&nbsp;
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${user.people}" var="people">
                            ${people}&nbsp;
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${user.location}" var="location">
                            ${location}&nbsp;
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${user.work}" var="work">
                            ${work}&nbsp;
                        </c:forEach>
                    </td>
                    <td>${user.other}</td>
                    <td>
                        <button onclick="deleteUser('${user.name}')">删除</button>
                        <button onclick="UpdateUser('${user.name}')">修改</button>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </fieldset>
</div>
</body>
</html>
