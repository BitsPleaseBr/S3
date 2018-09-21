package s3.api.method.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import com.amazonaws.http.HttpMethodName;
import s3.api.method.request.RequestBuilder;

public abstract class Resource {


  protected static final HttpMethodName POST = HttpMethodName.POST, GET = HttpMethodName.GET,
                                        DELETE = HttpMethodName.DELETE, PATCH = HttpMethodName.PATCH, PUT = HttpMethodName.PUT,
                                        HEAD = HttpMethodName.HEAD, OPTIONS = HttpMethodName.OPTIONS;


  protected HashMap<String, Object> pathMap = new HashMap<String, Object>();
  protected HashMap<String, Object> parameters = new HashMap<String, Object>();
  protected HttpMethodName httpMethod;
  protected RequestBuilder requestBuilder;
  protected Resource parentResource;
  
  protected Resource(HttpMethodName httpMethod) {
    
    resetPathMap();
    this.httpMethod = httpMethod;
  }
  

  public Resource putParameter(String key, Object value) {
    
    if (pathMap.containsKey(key))
      pathMap.put(key, value);
    else
      parameters.put(key, value);
    
    return this;
  }

  public Resource putParameters(HashMap<String, Object> parameters) {

    for (int i = 0; i < parameters.size(); i++) {

      Entry<String, Object> entrada = new ArrayList<Entry<String, Object>>(parameters.entrySet()).get(i);
      
      if (pathMap.containsKey(entrada.getKey())) {

        pathMap.put(entrada.getKey(), entrada.getValue());
        parameters.remove(entrada.getKey());
      }
    }
    
    this.parameters.putAll(parameters);
    return this;
  }

  public void setRequestBuilder(RequestBuilder requestBuilder) {

    this.requestBuilder = requestBuilder;
  }


  public String getPath() {

    String fullPath = "";

    for (String individualPath : getAbsolutePath().split("/")) {
      if (individualPath.equals(""))
        continue;
      fullPath += "/" + this.pathMap.get(individualPath);
    }
    
    resetPathMap();
    
    fullPath += this.parameters.size() > 0 ? "?" : "";
    
    int i = 0;
    
    for (Entry<String, Object> entrada : this.parameters.entrySet()) {
   
      fullPath += entrada.getKey() + "=" + entrada.getValue() + (i + 1 < this.parameters.size() ? "&" : "");
      
      i++;
    }
    
    return fullPath;
  }

  public abstract String getAbsolutePath();  
  
  public RequestBuilder getRequestBuilder() {

    return this.requestBuilder;
  }

  public HttpMethodName getHttpMethod() {

    return this.httpMethod;
  }


  protected void resetPathMap() {

    this.pathMap.clear();
    
    for (String individualPath : getAbsolutePath().split("/")) {
      if (individualPath.equals(""))
        continue;
      this.pathMap.put(individualPath, individualPath);
    }
  }
}
