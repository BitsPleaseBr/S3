package s3.api.users.selecionar.dados.paciente;

import java.sql.SQLException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import model.bean.PacienteBean;
import model.dao.PacienteDao;
import s3.api.Handler;

public class SelPacHandler extends Handler
    implements RequestHandler<SelPacRequest, SelPacResponse> {

  @Override
  public SelPacResponse handleRequest(SelPacRequest input, Context context) {

    setContext(context);

    SelPacResponse response = new SelPacResponse();
    PacienteBean ub = null;

    try {

      log("Obtendo dados do paciente...");

      ub = new PacienteDao().selecionar(input.getId());

      if (ub == null) {

        log("Paciente não encontrado!");
        response.addMessage("Falha", "Não foi possível encontrar o paciente");
      } else
        log("Dados obtidos com sucesso!");
    
    } catch (SQLException e) {

      response.setSucesso(false);
      response.addMessage("Falha", System.getenv("SQLException"));

      log(System.getenv("SQLException") + ": " + e.getMessage());

      return response;
    }

    response.setSucesso(true);
    response.setInfos(ub.getInfosPac());;

    log("A função foi executada com sucesso!");

    return response;
  }

}
