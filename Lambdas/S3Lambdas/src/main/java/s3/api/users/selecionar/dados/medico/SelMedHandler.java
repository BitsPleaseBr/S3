package s3.api.users.selecionar.dados.medico;

import java.sql.SQLException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import model.bean.MedicoBean;
import model.dao.MedicoDao;
import s3.api.Handler;

public class SelMedHandler extends Handler
    implements RequestHandler<SelMedRequest, SelMedResponse> {

  @Override
  public SelMedResponse handleRequest(SelMedRequest input, Context context) {

    setContext(context);

    SelMedResponse response = new SelMedResponse();
    MedicoBean ub = null;

    try {

      log("Obtendo dados do médico...");

      ub = new MedicoDao().selecionar(input.getId());

      if (ub == null) {

        log("Médico não encontrado!");
        response.addMessage("Falha", "Não foi possível encontrar o médico");
      } else
        log("Dados obtidos com sucesso!");

    } catch (SQLException e) {

      response.setSucesso(false);
      response.addMessage("Falha", System.getenv("SQLException"));

      log(System.getenv("SQLException") + ": " + e.getMessage());

      return response;
    }

    response.setSucesso(true);
    response.setInfos(ub.getInfosMed());

    log("A função foi executada com sucesso!");

    return response;
  }

}
