package s3.api.users.selecionar.dados.usuario;

import java.sql.SQLException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import model.bean.UserBean;
import model.bean.info.UserInfo;
import model.dao.UserDao;
import s3.api.Handler;

public class SelUseHandler extends Handler
    implements RequestHandler<SelUseRequest, SelUseResponse> {

  @Override
  public SelUseResponse handleRequest(SelUseRequest input, Context context) {

    setContext(context);

    SelUseResponse response = new SelUseResponse();
    UserBean ub = new UserBean() {};
    
    try {
      
      log("Obtendo dados do usuário...");
      
      ub = new UserDao() {}.selecionar(input.getId());
      
      if ((ub == null) || (ub.getInfo(UserInfo.Nome) == null)) {
        
        log("Usuário não encontrado!");
        response.addMessage("Falha", "Não foi possível encontrar o usuário");
      } else {
        
        log("Dados obtidos com sucesso!");
        response.setInfos(ub.getInfosUser());
      }
      
    } catch (SQLException e) {
      
      response.setSucesso(false);
      response.addMessage("Falha", System.getenv("SQLException"));

      log(System.getenv("SQLException") + ": " + e.getMessage());

      return response;
    }
    
    response.setSucesso(true);
    
    log("A função foi executada com sucesso!");
    
    return response;
  }

}
