<%@page import="prod.vo.LprodVO"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

// controller에서 저장한 데이터 꺼내기
@SuppressWarnings("unchecked")
List<LprodVO> list = (List<LprodVO>)request.getAttribute("Lprod");

// 자바객체 list를 클라이언트 쪽으로 전송하기 위해서 Json데이터로 직렬화
Gson gson = new GsonBuilder().setPrettyPrinting().create();
String json = gson.toJson(list);

out.print(json);
out.flush();


%>