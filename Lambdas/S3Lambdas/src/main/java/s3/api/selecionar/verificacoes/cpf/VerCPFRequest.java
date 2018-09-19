package s3.api.selecionar.verificacoes.cpf;

import s3.api.selecionar.SelecionarRequest;

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