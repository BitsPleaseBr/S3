package s3.api.users.cadastro.cadastros.paciente;

import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import model.bean.PacienteBean;
import model.bean.info.UserInfo;
import model.dao.PacienteDao;
import s3.api.Handler;
import s3.api.users.cadastro.cadastros.NotificadorSNS;

public class CadPacHandler extends Handler implements RequestHandler<CadPacRequest, CadPacResponse> {

  @Override
  public CadPacResponse handleRequest(CadPacRequest input, Context context) {

    setContext(context);
    
    CadPacResponse response = new CadPacResponse();

    PacienteBean pb = new PacienteBean();

    log("Definindo informações de usuário do paciente...");
    
    pb.setInfo(UserInfo.Nome, input.getNome());
    pb.setInfo(UserInfo.Sobrenome, input.getSobrenome());
    pb.setInfo(UserInfo.CPF, input.getCpf());
    pb.setInfo(UserInfo.DataNascimento, input.getDataNascimento());
    pb.setInfo(UserInfo.Email, input.getEmail());
    pb.setInfo(UserInfo.Senha, BCrypt.hashpw(input.getSenha(), BCrypt.gensalt()));

    int id = -1;
    try {

      log("Cadastrando paciente...");
      
      id = new PacienteDao().cadastrar(pb);

      log("Paciente cadastrado com sucesso!");
    } catch (SQLException e) {

      response.setSucesso(false);
      response.addMessage("Falha", System.getenv("SQLException"));
      
      log(System.getenv("SQLException") + ": " + e.getMessage());
      
      return response;
    }

    response.setId(id);
    response.setSucesso(true);
    log("Notificando cadastro no canal SNS");
    NotificadorSNS.publicarCadastro(pb.getInfo(UserInfo.Email).toString(), pb.getInfo(UserInfo.Nome).toString());
    
    log("A função foi executada com sucesso!");
    
    return response;
  }
}
