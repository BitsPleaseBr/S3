package s3.api.documentos.cadastrar;

import java.util.HashMap;
import s3.api.Request;

public class WriteDocRequest extends Request {

  
  private HashMap<String, Object> valores = new HashMap<String, Object>();
  
  
  public WriteDocRequest() {}
  
  
  public void setValores(HashMap<String, Object> valores) {
    
    this.valores = valores;
  }
  
  public HashMap<String, Object> getValores() {
    
    return this.valores;
  }
}