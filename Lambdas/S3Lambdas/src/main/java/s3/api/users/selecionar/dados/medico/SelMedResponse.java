package s3.api.users.selecionar.dados.medico;

import s3.api.users.selecionar.SelecionarResponse;

public class SelMedResponse extends SelecionarResponse {

  
  public SelMedResponse() {
    
    setLambdaInvocada("Lambda para obtenção de dados do médico");
  }
}