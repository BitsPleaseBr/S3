package s3.api.access;

import model.bean.EnderecoBean;
import model.bean.MedicoBean;
import model.bean.PacienteBean;
import model.bean.TelefoneBean;
import model.bean.UserBean;
import model.bean.info.EnderecoInfo;
import model.bean.info.MedicoInfo;
import model.bean.info.PacienteInfo;
import model.bean.info.TelefoneInfo;
import model.bean.info.UserInfo;
import s3.api.method.caller.MethodCaller;
import s3.api.method.request.Body;
import s3.api.method.request.Headers;
import s3.api.method.resources.tokens.Tokens;
import s3.api.method.resources.users.Users;
import s3.api.method.resources.users.id.Id;
import s3.api.method.resources.users.id.dados_paciente.DadosPaciente;
import s3.api.method.resources.users.id.dados_profissional.DadosProfissional;
import s3.api.method.resources.users.id.dados_usuario.DadosUsuario;
import s3.api.method.resources.users.id.enderecos.Enderecos;
import s3.api.method.resources.users.id.telefones.Telefones;
import s3.api.method.resources.verificar.Verificar;

public class MethodCallerFactory {


  // users
  // users-post
  public static MethodCaller cadastrarUser(UserBean bean) {

    Body body = new Body();

    body.putAll(bean.getInfosUser());

    if (bean.getEnderecos().size() > 0)
      body.put("enderecos", bean.getEnderecos());

    if (bean.getTelefones().size() > 0)
      body.put("telefones", bean.getTelefones());

    if (bean instanceof MedicoBean) {

      MedicoBean asMedico = (MedicoBean) bean;

      body.putAll(asMedico.getInfosMed());
    } else if (bean instanceof PacienteBean) {

      PacienteBean asPaciente = (PacienteBean) bean;

      body.putAll(asPaciente.getInfosPac());
    }

    return new MethodCaller(Users.CADASTRAR, body);
  }

  // users-get
  public static MethodCaller selecionarUsers() {
    return new MethodCaller(Users.SELECIONAR);
  }

  // users/{id}
  // users/{id}-delete
  public static MethodCaller deletarUser(int userId) {
    return new MethodCaller(Id.DELETAR).putParameter("id", userId);
  }

  // users/{id}-get
  public static MethodCaller selecionarUser(int userId) {
    return new MethodCaller(Id.SELECIONAR).putParameter("id", userId);
  }

  // users/{id}-patch
  public static MethodCaller atualizarUser(UserBean bean, UserInfo... infos) {

    Body body = new Body();

    for (UserInfo info : infos)
      body.put((String.valueOf(info)), bean.getInfo(info));

    int userId = (Integer) bean.getInfo(UserInfo.ID);
    return new MethodCaller(Id.ATUALIZAR_PARCIAL, body).putParameter("id", userId);
  }

  // users/{id}-put
  public static MethodCaller atualizarUser(UserBean bean) {

    int userId = (Integer) bean.getInfo(UserInfo.ID);
    return new MethodCaller(Id.ATUALIZAR, new Body(bean.getInfosUser())).putParameter("id", userId);
  }

  //users/{id}/dados-usuario
  //users/{id}/dados-usuario-get
  public static MethodCaller selecionarDadosUsuario(int userId) {
    
    return new MethodCaller(DadosUsuario.SELECIONAR).putParameter("id", userId);
  }
  
  //users/{id}/dados-usuario-patch
  public static MethodCaller atualizarDadosUsuario(UserBean bean, UserInfo... infos) {
    
    Body body = new Body();
    
    for (UserInfo info : infos)
      body.put(String.valueOf(info), bean.getInfo(info));
    
    int userId = (Integer) bean.getInfo(UserInfo.ID);
    return new MethodCaller(DadosUsuario.ATUALIZAR_PARCIAL, body).putParameter("id", userId);
  }
  
  //users/{id}/dados-usuario-put
  public static MethodCaller atualizarDadosUsuario(UserBean bean) {
    
    int userId = (Integer) bean.getInfo(UserInfo.ID);
    return new MethodCaller(DadosUsuario.ATUALIZAR, new Body(bean.getInfosUser())).putParameter("id", userId);
  }
  
  //users/{id}/dados-paciente
  //users/{id}/dados-paciente-get
  public static MethodCaller selecionarDadosPaciente(int userId) {
    
    return new MethodCaller(DadosPaciente.SELECIONAR).putParameter("id", userId);
  }
  
  //users/{id}/dados-paciente-patch
  public static MethodCaller atualizarDadosPaciente(PacienteBean bean, PacienteInfo... infos) {
    
    Body body = new Body();
    
    for (PacienteInfo info : infos)
      body.put(String.valueOf(info), info);
    
    int userId = (Integer) bean.getInfo(PacienteInfo.IDUser);
    return new MethodCaller(DadosPaciente.ATUALIAR_PARCIAL, body).putParameter("id", userId);
  }
  
  //users/{id}/dados-paciente-put
  public static MethodCaller atualizarDadosPaciente(PacienteBean bean) {
    
    int userId = (Integer) bean.getInfo(PacienteInfo.IDUser);
    return new MethodCaller(DadosPaciente.ATUALIZAR, new Body(bean.getInfosPac())).putParameter("id", userId);
  }
  
  // users/{id}/dados-profissional
  // users/{id}/dados-profissional-get
  public static MethodCaller selecionarDadosProfissional(int userId) {

    return new MethodCaller(DadosProfissional.SELECIONAR).putParameter("id", userId);
  }

  // users/{id}/dados-profissional-patch
  public static MethodCaller atualizarDadosProfissional(MedicoBean bean, MedicoInfo... infos) {

    Body body = new Body();

    for (MedicoInfo info : infos)
      body.put(String.valueOf(info), bean.getInfo(info));

    int userId = (Integer) bean.getInfo(MedicoInfo.IDUser);
    return new MethodCaller(DadosProfissional.ATUALIZAR_PARCIAL, body).putParameter("id", userId);
  }

  // users/{id}/dados-profissional-put
  public static MethodCaller atualizarDadosProfissional(MedicoBean bean) {

    int userId = (Integer) bean.getInfo(MedicoInfo.IDUser);
    return new MethodCaller(DadosProfissional.ATUALIZAR, new Body(bean.getInfosMed()))
        .putParameter("id", userId);
  }

  // users/{id}/enderecos
  // users/{id}/enderecos-get
  public static MethodCaller selecionarEndereco(int userId, int tipo) {

    return new MethodCaller(Enderecos.SELECIONAR).putParameter("id", userId)
        .putParameter("tipo-endereco", tipo);
  }

  // users/{id}/enderecos-put
  public static MethodCaller atualizarEndereco(EnderecoBean bean) {

    int userId = (Integer) bean.getInfo(EnderecoInfo.IDUser);
    return new MethodCaller(Enderecos.ATUALIZAR, new Body(bean.getInfosEnd())).putParameter("id",
        userId);
  }

  // users/{id}/telefones
  // users/{id}/telefones-get
  public static MethodCaller selecionarTelefone(int userId, int tipo) {

    return new MethodCaller(Telefones.SELECIONAR).putParameter("id", userId)
        .putParameter("tipo-telefone", tipo);
  }

  // users/{id}/telefones-put
  public static MethodCaller atualizarTelefone(TelefoneBean bean) {

    int userId = (Integer) bean.getInfo(TelefoneInfo.IDUser);
    return new MethodCaller(Telefones.ATUALIZAR, new Body(bean.getInfosTel())).putParameter("id",
        userId);
  }
  
  //users/{id}/especializacoes
  //users/{id}/especializacoes-get
  public static MethodCaller selecionarEspecializacao() {
    
    return null;
  }
  
  //users/{id}/especializacoes-post
  public static MethodCaller cadastrarEspecializacao() {
    
    return null;
  }
  
  //users/{id}/especializacoes-put
  public static MethodCaller atualizarEspecializacao() {
    
    return null;
  }


  // tokens
  // tokens/get
  public static MethodCaller gerarToken(String email, String senha) {

    Headers headers = new Headers();

    headers.put("email", email);
    headers.put("senha", senha);

    return new MethodCaller(Tokens.SELECIONAR).withApiKey("RE66Z7Dzv56HveU1nXat6aJy9a6U0F178ude2pnj").withHeaders(headers);
  }
  
  //verificar
  //verificar/email/{valor}
  public static MethodCaller verificarEmail(String email) {
    
    return new MethodCaller(Verificar.EMAIL).putParameter("valor", email);
  }
  
  //verificar/email/{valor}
  public static MethodCaller verificarCpf(String cpf) {
    
    return new MethodCaller(Verificar.CPF).putParameter("valor", cpf);
  }
}