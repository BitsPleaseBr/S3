package s3.api.method.resources.users.id.especializacoes;

import com.amazonaws.http.HttpMethodName;
import s3.api.method.resources.Resource;
import s3.api.method.resources.users.id.Id;

public class Especializacoes extends Resource {


  public static final Especializacoes CADASTRAR = new Especializacoes(POST),
      ATUALIZAR = new Especializacoes(PUT), SELECIONAR = new Especializacoes(GET);


  protected Especializacoes(HttpMethodName httpMethod) {

    super(httpMethod);
  }

  @Override
  public String getAbsolutePath() {

    if (this.parentResource == null)
      this.parentResource = new Id();
    
    return this.parentResource.getAbsolutePath() + "/especializacoes";
  }

}
