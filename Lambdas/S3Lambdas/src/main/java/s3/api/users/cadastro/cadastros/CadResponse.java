package s3.api.users.cadastro.cadastros;

import s3.api.users.cadastro.CadastroResponse;

public class CadResponse extends CadastroResponse {

  
  protected int id;
  
  
  public CadResponse(boolean sucesso, int id) {
    
    this.sucesso = sucesso;
    this.id = id;
  }
  
  
  public void setId(int id) {
    
    this.id = id;
  }
  
  public int getId() {
    
   return this.id;
  }
  
  public CadResponse() {}
}