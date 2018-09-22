package s3.api.method.response;

import java.io.IOException;
import java.util.HashMap;
import com.amazonaws.http.HttpResponse;
import com.google.gson.Gson;
import ca.ryangreen.apigateway.generic.GenericApiGatewayResponse;

public class S3ApiResponse extends GenericApiGatewayResponse {

  public S3ApiResponse(HttpResponse httpResponse) throws IOException {
    super(httpResponse);
  }

  
  public HashMap<String, Object> getHashBody() {
    
    @SuppressWarnings("unchecked")
    HashMap<String, Object> body = (HashMap<String, Object>) new Gson().fromJson(getBody(), HashMap.class);
    
    return body;
  }
}
