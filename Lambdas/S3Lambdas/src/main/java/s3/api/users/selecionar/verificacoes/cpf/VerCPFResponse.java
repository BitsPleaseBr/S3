package s3.api.users.selecionar.verificacoes.cpf;

import s3.api.users.selecionar.SelecionarResponse;

public class VerCPFResponse extends SelecionarResponse {

  
  private boolean valido;
  
  
  public VerCPFResponse(boolean sucesso, boolean valido) {
    
    setLambdaInvocada("Lambda Para Verificação de CPF");
    this.sucesso = sucesso;
    this.valido = valido;
  }
  
  
  public void setValido(boolean valido) {
    
    this.valido = valido;
  }
  
  public boolean getValido() {
    
    return this.valido;
  }
  
  public VerCPFResponse() {
    
    setLambdaInvocada("Lambda Para Verificação de CPF");
  }
}