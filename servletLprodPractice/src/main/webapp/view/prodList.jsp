<%@page import="prod.vo.ProdVO"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// controller에서 저장한 값 꺼내기
	@SuppressWarnings("unchecked")
	List<ProdVO> list = (List<ProdVO>)request.getAttribute("list");

	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	String json = gson.toJson(list);
	
	out.print(json);
	out.flush();

%>