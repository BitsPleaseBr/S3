package s3.api.method.resources.users.id.dados_paciente;

import com.amazonaws.http.HttpMethodName;
import s3.api.method.resources.Resource;
import s3.api.method.resources.users.id.Id;

public class DadosPaciente extends Resource {

  
  public static final DadosPaciente SELECIONAR = new DadosPaciente(GET), ATUALIZAR = new DadosPaciente(PUT), ATUALIAR_PARCIAL = new DadosPaciente(PATCH);
  
  
  protected DadosPaciente(HttpMethodName httpMethod) {
    
    super(httpMethod);
  }

  @Override
  public String getAbsolutePath() {
    
    if (this.parentResource == null)
      this.parentResource = new Id();
    
    return this.parentResource.getAbsolutePath() + "/dados-paciente";
  }

}
