<%--
  Created by IntelliJ IDEA.
  User: zhanghao
  Date: 16/4/30
  Time: 上午12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>素性检测</title>
  </head>
  <body>
    <form action="/primality/certainly" method="get">
      <input type="text" name="num" value="请输入一个数字" style="width: 60%">
      <input type="submit" value="判断"/>
    </form>
  </body>
</html>
