<%@ page import="java.util.List" %>
<%@ page import="com.thoughtWorks.model.Item" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangzhihui
  Date: 14-11-9
  Time: 上午9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
   <center><h1>Item List</h1><hr/>
       <% List<Item> items = (List<Item>) request.getAttribute("items");
          for(Item item: items){
              request.setAttribute("item", item);
          }
       %>
      ${item.id}|${item.barcode}|${item.name}|${item.price}|${item.unit}
       <%
          request.removeAttribute("item");
       %>
   </center>
</body>
</html>
