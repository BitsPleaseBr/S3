package s3.api.method.resources.users.id.dados_usuario;

import com.amazonaws.http.HttpMethodName;
import s3.api.method.resources.Resource;
import s3.api.method.resources.users.id.Id;

public class DadosUsuario extends Resource {

  
  public static final DadosUsuario SELECIONAR = new DadosUsuario(GET), ATUALIZAR_PARCIAL = new DadosUsuario(PATCH), ATUALIZAR = new DadosUsuario(PUT);
  
  
  protected DadosUsuario(HttpMethodName httpMethod) {
    
    super(httpMethod);
  }

  @Override
  public String getAbsolutePath() {
    
    if (parentResource == null)
      this.parentResource = new Id();
    
    return parentResource.getAbsolutePath() + "/dados-usuario";
  }
}