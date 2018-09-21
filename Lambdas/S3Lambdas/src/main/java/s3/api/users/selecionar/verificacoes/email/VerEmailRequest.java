package s3.api.users.selecionar.verificacoes.email;

import s3.api.users.selecionar.SelecionarRequest;

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