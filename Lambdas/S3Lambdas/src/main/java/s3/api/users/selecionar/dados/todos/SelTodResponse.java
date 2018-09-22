package s3.api.users.selecionar.dados.todos;

import s3.api.users.selecionar.SelecionarResponse;

public class SelTodResponse extends SelecionarResponse {

  
  public SelTodResponse() {
    
    setLambdaInvocada("Lambda para obter todos os dados disponíveis de um usuário");
  }
}