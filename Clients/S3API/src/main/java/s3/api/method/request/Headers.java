package s3.api.method.request;

import java.util.HashMap;

public class Headers {

  
  private RequestBuilder builder;
  private HashMap<String, String> values = new HashMap<String, String>();
  
  
  public Headers(RequestBuilder builder) {
    
    this();
    this.builder = builder;
  }
  
  public Headers() {
    
    put("Content-Type", "application/json");
  }
  
  
  public Headers put(String key, String value) {
    
    values.put(key, value);
    return this;
  }
  
  public Headers setValues(HashMap<String, String> mapa) {
    
    this.values = mapa;
    return this;
  }
  
  public HashMap<String, String> getValues() {
    
    return this.values;
  }
  
  public Headers setRequestBuilder(RequestBuilder builder) {
    
    this.builder = builder;
    return this;
  }
  
  public RequestBuilder getRequestBuilder() {
    
    return this.builder;
  }
}