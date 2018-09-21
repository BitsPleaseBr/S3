package s3.api.documentos.cadastrar;

import java.util.HashMap;
import s3.api.Request;

public class WriteDocRequest extends Request {

  
  private HashMap<String, Object> body = new HashMap<String, Object>();
  private int idUsuario, idCasoMedico, idExame;
  
  
  public WriteDocRequest() {}
  
  
  public void setBody(HashMap<String, Object> body) {
    
    this.body = body;
  }
  
  public HashMap<String, Object> getBody() {
    
    return this.body;
  }


  public int getIdUsuario() {
    return idUsuario;
  }


  public void setIdUsuario(int idUsuario) {
    this.idUsuario = idUsuario;
  }


  public int getIdCasoMedico() {
    return idCasoMedico;
  }


  public void setIdCasoMedico(int idCasoMedico) {
    this.idCasoMedico = idCasoMedico;
  }


  public int getIdExame() {
    return idExame;
  }


  public void setIdExame(int idExame) {
    this.idExame = idExame;
  }
  
  
}