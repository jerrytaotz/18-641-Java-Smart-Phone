<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Here is what you selected:</h1>
<%
	float totalCost = 0;
	float basePrice = Float.parseFloat(request.getParameter("baseprice"));
	totalCost += basePrice;
	String name = request.getParameter("name");
	int totalOptionNum = Integer.parseInt(request.getParameter("totalOptionNum"));
	String[] optionset = new String[totalOptionNum];
	String[] option_name = new String[totalOptionNum];
	float[] option_price = new float[totalOptionNum];
	for(int i=0; i<totalOptionNum; i++) {
		String opset_temp = request.getParameter("optionSet"+i);
		String[] temp = opset_temp.split(",");
		optionset[i] = temp[0];
		option_name[i] = temp[1];
		option_price[i] = Float.parseFloat(temp[2]);
		totalCost += option_price[i];
	}
%>
<table border="1">
<tr>
	<td><%= name %></td>
	<td>base price</td>
	<td><%= basePrice %></td>
</tr>
<% for(int i=0; i<totalOptionNum; i++) { %>
<tr>
	<td><%= optionset[i] %></td>
	<td><%= option_name[i] %></td>
	<td><%= option_price[i] %></td>
</tr>
<% } %>
<tr style="font-weight: bold">
	<td>Total Cost</td>
	<td></td>
	<td>$<%= totalCost %></td>
</tr>
</table>
</center>
</body>
</html>