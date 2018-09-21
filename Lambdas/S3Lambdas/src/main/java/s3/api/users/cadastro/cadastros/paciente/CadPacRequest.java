package s3.api.users.cadastro.cadastros.paciente;

import s3.api.users.cadastro.cadastros.CadRequest;

public class CadPacRequest extends CadRequest {
  
  
  public CadPacRequest(String nome, String sobrenome, String cpf, String dataNascimento, String email, String senha) {
    
    super(nome, sobrenome, cpf, dataNascimento, email, senha);
  }
  
  
  public CadPacRequest() {}
}