package s3.api.method.resources.verificar;

import com.amazonaws.http.HttpMethodName;
import s3.api.method.resources.Resource;

public class Verificar extends Resource {
  
  
  public static final Verificar EMAIL = new Verificar("email/valor", GET), CPF = new Verificar("cpf/valor", GET);
  
  
  private String extra;
  
  public Verificar(String extraPath, HttpMethodName httpMethod) {
    
    super(httpMethod);
    
    this.extra = extraPath;
  }

  @Override
  public String getAbsolutePath() {
    
    return "/verificar/" + extra;
  }

}
