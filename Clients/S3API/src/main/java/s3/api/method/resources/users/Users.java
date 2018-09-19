package s3.api.method.resources.users;

import com.amazonaws.http.HttpMethodName;
import s3.api.method.resources.Resource;

public class Users extends Resource {

  
  public static final Users CADASTRAR = new Users(POST), SELECIONAR = new Users(GET);
  
  
  protected Users(HttpMethodName httpMethod) {

    super(httpMethod);
  }
  
  public Users() { super(null); }
  
  @Override
  public String getAbsolutePath() {
   
    return "/prod/users";
  }
}