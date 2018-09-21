package s3.api;

import java.util.HashMap;

public class Request {


  private String tipo;
  private HashMap<String, Object> valores;


  public void setTipo(String tipo) {

    this.tipo = tipo;
  }

  public String getTipo() {

    return this.tipo;
  }

  public HashMap<String, Object> getValores() {
    return valores;
  }

  public void setValores(HashMap<String, Object> valores) {
    this.valores = valores;
  }
}