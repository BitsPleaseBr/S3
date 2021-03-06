<%@page import="control.crypto.PswdStorage"%>
<%@page import="model.dao.PacienteDao"%>
<%@page import="model.bean.info.UserInfo"%>
<%@page import="model.bean.PacienteBean"%>
<%@page import="s3.api.access.MethodCallerFactory" %>
<%
  PacienteBean pb = new PacienteBean();

  //Obtendo email e senha
  String email = request.getParameter("emailPac");
  String senha = request.getParameter("senhaPac");

  pb.setInfo(UserInfo.Nome, request.getParameter("nome"));
  pb.setInfo(UserInfo.Sobrenome, request.getParameter("sobrenome"));
  pb.setInfo(UserInfo.CPF, request.getParameter("cpf"));
  pb.setInfo(UserInfo.DataNasc, request.getParameter("data"));
  pb.setInfo(UserInfo.Email, email);
  pb.setInfo(UserInfo.Senha, PswdStorage.clientPswdHash(senha, email));

  //Inserindo no banco de dados
  out.print(MethodCallerFactory.cadastrarUser(pb).call().getBody());

  response.sendRedirect("../index.jsp");
%>