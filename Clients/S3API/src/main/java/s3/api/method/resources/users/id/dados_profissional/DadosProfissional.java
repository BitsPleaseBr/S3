package s3.api.method.resources.users.id.dados_profissional;

import com.amazonaws.http.HttpMethodName;
import s3.api.method.resources.Resource;
import s3.api.method.resources.users.id.Id;

public class DadosProfissional extends Resource {


  public static final DadosProfissional SELECIONAR = new DadosProfissional(GET), ATUALIZAR = new DadosProfissional(PUT), ATUALIZAR_PARCIAL = new DadosProfissional(PATCH);
  
  
  protected DadosProfissional(HttpMethodName httpMethod) {
      
      super(httpMethod);     
    }

  @Override
  public String getAbsolutePath() {

    if (parentResource == null)
      this.parentResource = new Id();
    
    return parentResource.getAbsolutePath() + "/dados-profissional";
  }
}
