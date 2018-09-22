package s3.api.users.selecionar.dados.todos;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import s3.api.Handler;

public class SelTodHandler extends Handler implements RequestHandler<SelTodRequest, SelTodResponse> {

  @Override
  public SelTodResponse handleRequest(SelTodRequest input, Context context) {
    
    setContext(context);
    
    SelTodResponse response = new SelTodResponse();
    
    return response;
  }

}
