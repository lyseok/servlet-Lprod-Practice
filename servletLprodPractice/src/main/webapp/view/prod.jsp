<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="prod.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ProdVO vo = (ProdVO)request.getAttribute("pvo");
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	String json = gson.toJson(vo);
	
	out.print(json);
	out.flush();


%>