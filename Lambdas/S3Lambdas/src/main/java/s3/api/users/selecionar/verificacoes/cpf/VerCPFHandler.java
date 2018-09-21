package s3.api.users.selecionar.verificacoes.cpf;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import model.bean.info.Tabela;
import model.bean.info.UserInfo;
import model.dao.statement.StatementBuilder;
import s3.api.Handler;

public class VerCPFHandler extends Handler implements RequestHandler<VerCPFRequest, VerCPFResponse> {

  @Override
  public VerCPFResponse handleRequest(VerCPFRequest input, Context context) {

    setContext(context);
    
    VerCPFResponse response = new VerCPFResponse();
    
    String cpf = input.getCPF();
    
    StatementBuilder sf = new StatementBuilder();
    ResultSet rs;
    try {
      
      log("Executando statement para comunicação com banco de dados...");
      
      rs = sf.withTabela(Tabela.User).withTipo(sf.SELECT).withInfos(UserInfo.Situacao).addCondition(UserInfo.CPF).addConditionValue(cpf).build().executeQuery();
   
      boolean valido = true;
      
      if (rs.next()) {
        if (rs.getInt(1) > 3) {
          valido = false;
        }
      }
      
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
