package s3.api.method.caller;

import java.util.HashMap;
import com.amazonaws.ClientConfiguration;
import ca.ryangreen.apigateway.generic.GenericApiGatewayClient;
import ca.ryangreen.apigateway.generic.GenericApiGatewayRequest;
import ca.ryangreen.apigateway.generic.GenericApiGatewayResponse;
import s3.api.method.client.ClientBuilder;
import s3.api.method.request.Body;
import s3.api.method.request.Headers;
import s3.api.method.request.RequestBuilder;
import s3.api.method.resources.Resource;

public class MethodCaller {

  
  private ClientBuilder clientBuilder = new ClientBuilder();
  private RequestBuilder requestBuilder = new RequestBuilder();
  
  
  public MethodCaller() {
    
    clientBuilder.withClientConfiguration(new ClientConfiguration());
  }
  
  public MethodCaller(Resource resource) {
    
    this();
    requestBuilder.withResource(resource);
  }
  
  public MethodCaller(Resource resource, Body body) {
    
    this(); 
    requestBuilder.withBody(body).withResource(resource);
  }
  
  
  public MethodCaller putParameter(String key, Object value) {
    
    getRequestBuilder().getResource().putParameter(key, value);
    return this;
  }
  
  public MethodCaller putParameters(HashMap<String, Object> parameters) {
    
    getRequestBuilder().getResource().putParameters(parameters);
    return this;
  }
  
  public MethodCaller withApiKey(String apiKey) {
    
    this.clientBuilder.withApiKey(apiKey);
    return this;
  }
  
  public MethodCaller withHeaders(Headers headers) {
    
    this.requestBuilder.withHeaders(headers);
    return this;
  }
  
  
  public ClientBuilder getClientBuilder() {
    
    return this.clientBuilder.setMethodCaller(this);
  }
  
  public RequestBuilder getRequestBuilder() {
    
    return this.requestBuilder.setMethodCaller(this);
  }
  
  
  public GenericApiGatewayResponse call() {
    
    GenericApiGatewayRequest request = requestBuilder.build();
    GenericApiGatewayClient client = clientBuilder.build();
    
    return client.execute(request);
  }
}