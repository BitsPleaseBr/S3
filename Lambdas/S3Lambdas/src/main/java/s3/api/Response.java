package s3.api;

import java.util.HashMap;

public class Response {

  
  protected boolean sucesso;
  private HashMap<String, String> messages = new HashMap<>();
  protected String lambdaInvocada;
  
  
  public void setLambdaInvocada(String nome) {
    
    this.lambdaInvocada = nome;
  }
  
  public String getLambdaInvocada() {
    
    return this.lambdaInvocada;
  }
  
  public Response(boolean sucesso, HashMap<String, String> messages) {
    
    this.sucesso = sucesso;
    this.messages = messages;
  }
  
  
  public boolean getSucesso() {
    return sucesso;
  }
  public void setSucesso(boolean sucesso) {
    this.sucesso = sucesso;
  }
  
  public HashMap<String, String> getMessages() {
    return messages;
  }
  public void addMessage(String key, String value) {
    
    messages.put(key, value);
  }
  
  
  public Response() {}
}