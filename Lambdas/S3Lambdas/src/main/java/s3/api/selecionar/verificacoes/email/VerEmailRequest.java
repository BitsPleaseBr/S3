package s3.api.selecionar.verificacoes.email;

import s3.api.selecionar.SelecionarRequest;

public class VerEmailRequest extends SelecionarRequest {

  
  private String email;
  
  
  public VerEmailRequest(String email) {
    
    this.email = email;
  }
  
  
  public void setEmail(String email) {
    
    this.email = email;
  }
  
  public String getEmail() {
    
    return this.email;
  }
  
  
  public VerEmailRequest() {}
}