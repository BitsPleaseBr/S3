package s3.api.method.request;

import java.io.ByteArrayInputStream;
import com.amazonaws.http.HttpMethodName;
import com.google.gson.Gson;
import ca.ryangreen.apigateway.generic.GenericApiGatewayRequest;
import ca.ryangreen.apigateway.generic.GenericApiGatewayRequestBuilder;
import s3.api.method.caller.MethodCaller;
import s3.api.method.resources.Resource;

public class RequestBuilder extends GenericApiGatewayRequestBuilder {


  private Headers headers;
  private Body body;
  private Resource resource;
  private MethodCaller methodCaller;


  public RequestBuilder() {

    this.headers = new Headers(this);
    this.body = new Body(this);
  }
  
  
  public RequestBuilder withHeaders(Headers headers) {
    
    this.headers = headers;
    return this;
  }

  public RequestBuilder withBody(Body body) {

    this.body = body;
    return this;
  }  

  public RequestBuilder withResource(Resource resource) {

    resource.setRequestBuilder(this);
    this.resource = resource;
    return this;
  }

  public RequestBuilder setMethodCaller(MethodCaller caller) {

    this.methodCaller = caller;
    return this;
  }
  
  
  public Headers getHeaders() {

    return this.headers;
  }
  
  public Body getBody() {

    return this.body;
  }

  public Resource getResource() {
    
    return this.resource;
  }
  
  public MethodCaller getMethodCaller() {

    return this.methodCaller;
  }


  @Override
  public GenericApiGatewayRequest build() {

    super.withHeaders(this.headers.getValues());
 
    if (this.resource.getHttpMethod().equals(HttpMethodName.POST))
      super.withBody(new ByteArrayInputStream(new Gson().toJson(this.body.getValues()).getBytes()));
    
    super.withHttpMethod(this.resource.getHttpMethod());
    super.withResourcePath(this.resource.getPath());
    
    return super.build();
  }
}