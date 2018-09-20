package s3.api.documentos;

import java.util.HashMap;
import s3.api.Response;

public class WriteDocResponse extends Response {

  public WriteDocResponse(boolean sucesso, HashMap<String, String> messages) {
    
    super(sucesso, messages);
  }

  public WriteDocResponse() {
    
    setLambdaInvocada("Lambda para upload de documentos");
  }
}