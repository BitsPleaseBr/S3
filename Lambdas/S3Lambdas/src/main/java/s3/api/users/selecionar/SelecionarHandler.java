package s3.api.users.selecionar;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import s3.api.Handler;
import s3.api.users.selecionar.dados.medico.SelMedHandler;
import s3.api.users.selecionar.dados.medico.SelMedRequest;
import s3.api.users.selecionar.dados.paciente.SelPacHandler;
import s3.api.users.selecionar.dados.paciente.SelPacRequest;
import s3.api.users.selecionar.dados.todos.SelTodHandler;
import s3.api.users.selecionar.dados.todos.SelTodRequest;
import s3.api.users.selecionar.dados.usuario.SelUseHandler;
import s3.api.users.selecionar.dados.usuario.SelUseRequest;
import s3.api.users.selecionar.verificacoes.cpf.VerCPFHandler;
import s3.api.users.selecionar.verificacoes.cpf.VerCPFRequest;
import s3.api.users.selecionar.verificacoes.email.VerEmailHandler;
import s3.api.users.selecionar.verificacoes.email.VerEmailRequest;

public class SelecionarHandler extends Handler
    implements RequestHandler<SelecionarRequest, SelecionarResponse> {


  private final static String SELECIONAR_DADOS_PACIENTE =
      System.getenv("SELECIONAR_DADOS_PACIENTE"),
      SELECIONAR_DADOS_MEDICO = System.getenv("SELECIONAR_DADOS_MEDICO"),
      SELECIONAR_DADOS_USUARIO = System.getenv("SELECIONAR_DADOS_USUARIO"),
      SELECIONAR_TODOS_DADOS = System.getenv("SELECIONAR_TODOS_DADOS"),
      VERIFICAR = System.getenv("VERIFICAR");


  @Override
  public SelecionarResponse handleRequest(SelecionarRequest input, Context context) {

    setContext(context);

    SelecionarResponse response = new SelecionarResponse();

    Gson g = new Gson();
    String json = g.toJson(input.getValores());

    String tipo = input.getTipo();

    if (tipo.equals(SELECIONAR_TODOS_DADOS))
      return new SelTodHandler().handleRequest(g.fromJson(json, SelTodRequest.class), context);
    
    if (tipo.equals(SELECIONAR_DADOS_MEDICO))
      return new SelMedHandler().handleRequest(g.fromJson(json, SelMedRequest.class), context);

    if (tipo.equals(SELECIONAR_DADOS_PACIENTE))
      return new SelPacHandler().handleRequest(g.fromJson(json, SelPacRequest.class), context);

    if (tipo.equals(SELECIONAR_DADOS_USUARIO))
      return new SelUseHandler().handleRequest(g.fromJson(json, SelUseRequest.class), context);

    if (tipo.equals(VERIFICAR)) {
      
      if (input.getValores().get("email") != null)
        return new VerEmailHandler().handleRequest(g.fromJson(json, VerEmailRequest.class), context);
        
      if (input.getValores().get("cpf") != null)
        return new VerCPFHandler().handleRequest(g.fromJson(json, VerCPFRequest.class), context);
    }
      

    response.setSucesso(true);
    response.addMessage("Erro de Tipo", "Não foi encontrada nenhuma função lambda para o tipo " + tipo);
    
    log("A função foi executada com sucesso!");

    return response;
  }
}
