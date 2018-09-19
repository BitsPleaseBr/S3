package s3.api.selecionar.dados.paciente;

import s3.api.selecionar.SelecionarResponse;

public class SelPacResponse extends SelecionarResponse {

  
  public SelPacResponse() {
    
    setLambdaInvocada("Lambda para obtenção de dados do paciente");
  }
}
