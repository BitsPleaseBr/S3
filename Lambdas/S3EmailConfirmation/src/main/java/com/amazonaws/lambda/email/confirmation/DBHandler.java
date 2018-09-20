package com.amazonaws.lambda.email.confirmation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBHandler {
  private static Connection connection = ConnectionFactory.getConnection();
  private static String campoID = System.getenv("campoIDBD");
  private static String campoStatus = System.getenv("campoStatusBD");
  private static String tabelaUserBD = System.getenv("tabelaUserBD");
  private static String campoEmail = System.getenv("campoEmailBD");
  private String id;
  private String email;
  private boolean usuarioExiste;

  public String getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public boolean existe() {

    return usuarioExiste;
  }

  public void confirmarEmail() {
    String sqlQuery = ""; // Update query usando id
    try {
      PreparedStatement statement = connection.prepareStatement(sqlQuery);
      statement.executeQuery();
    } catch (Exception e) {
      System.out.println("Erro de conexão com BD ao atualizar status do usuário");
      e.printStackTrace();
    }
  }

  DBHandler(String email) {
    this.email = email;

    // Busca os dados no banco de dados
    String sqlQuery =
        String.format("SELECT %s FROM %s WHERE %s = %s", campoID, tabelaUserBD, campoEmail, email);
    try {
      PreparedStatement statement = connection.prepareStatement(sqlQuery);
      ResultSet results = statement.executeQuery();
      usuarioExiste = results.next();
      if (usuarioExiste) {
        id = results.getString(campoID);
      }
    } catch (Exception e) {
      System.out.println("Erro ao accesar banco de dados para verificar email");
      e.printStackTrace();
    }
  }
}
