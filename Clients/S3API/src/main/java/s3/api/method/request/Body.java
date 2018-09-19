package s3.api.method.request;

import java.util.HashMap;
import com.google.gson.Gson;

public class Body {

  
  private RequestBuilder builder;
  private HashMap<String, Object> values = new HashMap<String, Object>();
  
  
  public Body(RequestBuilder builder) {
    
    this.builder = builder;
  }
  
  public <K, V> Body(HashMap<K, V> values) {
    
    this.putAll(values);
  }
  
  public Body() {}
  
  
  public Body put(String key, Object value) {
    
    this.values.put(key, value);
    return this;
  }
  
  @SuppressWarnings("unchecked")
  public <K, V> Body putAll(HashMap<K, V> newValues) {
    
    Gson g = new Gson();
    
    HashMap<String, Object> values = (HashMap<String, Object>) g.fromJson(g.toJson(newValues), HashMap.class);

    this.values.putAll(values);
    return this;
  }
  
  public Body setValues(HashMap<String, Object> newValues) {
    
    this.values = newValues;
    return this;
  }
  
  public HashMap<String, Object> getValues() {
    
    return this.values;
  }
  
  
  public Body setRequestBuilder(RequestBuilder builder) {
    
    this.builder = builder;
    return this;
  }
  
  public RequestBuilder getRequestBuilder() {
    
    return this.builder;
  }
}