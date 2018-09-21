package s3.api.method.resources.users.id;

import com.amazonaws.http.HttpMethodName;
import s3.api.method.resources.Resource;
import s3.api.method.resources.users.Users;

public class Id extends Resource {


  public static final Id SELECIONAR = new Id(GET), DELETAR = new Id(DELETE),
                         ATUALIZAR = new Id(PUT), ATUALIZAR_PARCIAL = new Id(PATCH);
  
  protected Id(HttpMethodName httpMethod) {

    super(httpMethod);
  }

  public Id() { super(null); }
  
  @Override
  public String getAbsolutePath() {

    if (parentResource == null)
      this.parentResource = new Users();
    
    return parentResource.getAbsolutePath() + "/id";
  }
}