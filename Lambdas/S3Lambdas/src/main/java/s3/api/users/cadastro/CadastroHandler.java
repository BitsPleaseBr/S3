package s3.api.users.cadastro;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import s3.api.Handler;
import s3.api.users.cadastro.cadastros.medico.CadMedHandler;
import s3.api.users.cadastro.cadastros.medico.CadMedRequest;
import s3.api.users.cadastro.cadastros.paciente.CadPacHandler;
import s3.api.users.cadastro.cadastros.paciente.CadPacRequest;

public class CadastroHandler extends Handler
    implements RequestHandler<CadastroRequest, CadastroResponse> {


  private final static String CADASTRO_MEDICO = System.getenv("CADASTRAR_MEDICO"),
                              CADASTRO_PACIENTE = System.getenv("CADASTRAR_PACIENTE");


  @Override
  public CadastroResponse handleRequest(CadastroRequest input, Context context) {

    setContext(context);

    CadastroResponse response = new CadastroResponse();
    
    Gson g = new Gson();
    String json = g.toJson(input.getValores());

    log("Redirecionando request...");

    String tipo = input.getTipo();
    
    if (tipo.equals(CADASTRO_MEDICO))
      return new CadMedHandler().handleRequest(g.fromJson(json, CadMedRequest.class), context);

    if (tipo.equals(CADASTRO_PACIENTE))
      return new CadPacHandler().handleRequest(g.fromJson(json, CadPacRequest.class), context);

    response.setSucesso(true);
    response.addMessage("Erro de Tipo", "Não foi encontrada nenhuma função lambda para o tipo " + tipo);
    
    log("A função foi executada com sucesso!");
    
    return response;
  }
}
