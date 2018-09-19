package s3.api.method.client;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import ca.ryangreen.apigateway.generic.GenericApiGatewayClient;
import ca.ryangreen.apigateway.generic.GenericApiGatewayClientBuilder;
import s3.api.method.caller.MethodCaller;

public class ClientBuilder extends GenericApiGatewayClientBuilder {


  private String endpoint = "https://bh7xqk7gcj.execute-api.sa-east-1.amazonaws.com";
  private Region region = Region.getRegion(Regions.fromName("sa-east-1"));
  private MethodCaller methodCaller;


  @Override
  public GenericApiGatewayClientBuilder withEndpoint(String endpoint) {
    return this;
  }

  @Override
  public GenericApiGatewayClientBuilder withRegion(Region region) {
    return this;
  }


  public ClientBuilder setMethodCaller(MethodCaller caller) {

    this.methodCaller = caller;
    return this;
  }

  public MethodCaller getMethodCaller() {

    return this.methodCaller;
  }

  @Override
  public GenericApiGatewayClient build() {

    super.withEndpoint(endpoint);
    super.withRegion(region);
    
    return super.build();
  }
}
