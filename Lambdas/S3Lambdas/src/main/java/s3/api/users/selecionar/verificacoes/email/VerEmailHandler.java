package s3.api.users.selecionar.verificacoes.email;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import model.bean.info.Tabela;
import model.bean.info.UserInfo;
import model.dao.statement.StatementBuilder;
import s3.api.Handler;

public class VerEmailHandler extends Handler implements RequestHandler<VerEmailRequest, VerEmailResponse> {

  @Override
  public VerEmailResponse handleRequest(VerEmailRequest input, Context context) {

    setContext(context);
    
    VerEmailResponse response = new VerEmailResponse();
    
    String email = input.getEmail();

    StatementBuilder sf = new StatementBuilder();

    try {
      
      log("Executando statement para comunicação com banco de dados...");
      
      ResultSet rs = sf.withTabela(Tabela.User).withTipo(sf.SELECT).withInfos(UserInfo.ID).addCondition(UserInfo.Email).addConditionValue(email).build().executeQuery();
      
      boolean valido = !rs.next();
      
      response.setValido(valido);
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
