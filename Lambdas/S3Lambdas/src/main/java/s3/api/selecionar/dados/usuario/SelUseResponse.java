package s3.api.selecionar.dados.usuario;

import s3.api.selecionar.SelecionarResponse;

public class SelUseResponse extends SelecionarResponse {

  
  public SelUseResponse() {
    
    setLambdaInvocada("Lambda para obtenção de dados do usuário");
  }
}