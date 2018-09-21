package s3.api.method.resources.users.id.enderecos;

import com.amazonaws.http.HttpMethodName;
import s3.api.method.resources.Resource;
import s3.api.method.resources.users.id.Id;

public class Enderecos extends Resource {

  
  public static final Enderecos SELECIONAR = new Enderecos(GET), ATUALIZAR = new Enderecos(PUT);
  
  
  protected Enderecos(HttpMethodName httpMethod) {
    
    super(httpMethod);
  }
  
  @Override
  public String getAbsolutePath() {
    
    if (parentResource == null)
      this.parentResource = new Id();
    
    return this.parentResource.getAbsolutePath() + "/enderecos";
  }
}