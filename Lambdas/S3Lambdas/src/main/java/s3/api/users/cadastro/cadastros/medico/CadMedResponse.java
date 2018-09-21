package s3.api.users.cadastro.cadastros.medico;

import s3.api.users.cadastro.cadastros.CadResponse;

public class CadMedResponse extends CadResponse {

  
  public CadMedResponse(boolean sucesso, int id) {
    
    super(sucesso, id);
    
    setLambdaInvocada("Lambda para Cadastro de Médicos");
  }
  
  
  public CadMedResponse() {
    
    setLambdaInvocada("Lambda para Cadastro de Médicos");
  }
}