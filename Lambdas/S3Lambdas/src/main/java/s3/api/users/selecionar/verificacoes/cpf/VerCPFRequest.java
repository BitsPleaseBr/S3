package s3.api.users.selecionar.verificacoes.cpf;

import s3.api.users.selecionar.SelecionarRequest;

public class VerCPFRequest extends SelecionarRequest {

  
  private String cpf;
  
  
  public VerCPFRequest(String cpf) {
    
    this.cpf = cpf;
  }
  
  
  public void setCPF(String cpf) {
    
    this.cpf = cpf;
  }
  
  public String getCPF() {
    
    return this.cpf;
  }
  
  
  public VerCPFRequest() {}
}