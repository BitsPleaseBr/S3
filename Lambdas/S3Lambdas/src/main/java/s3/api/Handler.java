package s3.api;

import com.amazonaws.services.lambda.runtime.Context;

public class Handler {

  
  private Context c;
  
  
  protected Handler log(String log) {
    
    c.getLogger().log("---" + log + "---\n");
    
    return this;
  }
  
  protected Handler setContext(Context c) {
    
    this.c = c;
    
    return this;
  }
}