package s3.api.method.resources.tokens;

import com.amazonaws.http.HttpMethodName;
import s3.api.method.resources.Resource;

public class Tokens extends Resource {

  
  public static final Tokens SELECIONAR = new Tokens(GET);
  
  
  protected Tokens(HttpMethodName httpMethod) {
    
    super(httpMethod);
  }

  @Override
  public String getAbsolutePath() {
    
    return "/prod/tokens";
  }

}
