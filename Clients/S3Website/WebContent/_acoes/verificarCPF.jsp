<%@page import="s3.api.access.MethodCallerFactory"%>
<%

	String cpf = request.getParameter("cpf");

	out.print(MethodCallerFactory.verificarCPF(cpf).call().getBody());
%>