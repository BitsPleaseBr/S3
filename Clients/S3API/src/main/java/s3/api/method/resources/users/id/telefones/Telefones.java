package s3.api.method.resources.users.id.telefones;

import com.amazonaws.http.HttpMethodName;
import s3.api.method.resources.Resource;
import s3.api.method.resources.users.id.Id;

public class Telefones extends Resource {


  public static final Telefones SELECIONAR = new Telefones(GET), ATUALIZAR = new Telefones(PUT);


  protected Telefones(HttpMethodName httpMethod) {

    super(httpMethod);
  }

  @Override
  public String getAbsolutePath() {

    if (parentResource == null)
      this.parentResource = new Id();

    return this.parentResource.getAbsolutePath() + "/telefones";
  }

}
