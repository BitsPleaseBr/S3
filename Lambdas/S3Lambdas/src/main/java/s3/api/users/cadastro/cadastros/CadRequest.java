package s3.api.users.cadastro.cadastros;

import s3.api.users.cadastro.CadastroRequest;

public class CadRequest extends CadastroRequest {

  
  protected String nome, sobrenome, cpf, dataNascimento, email, senha;

  
  public CadRequest(String nome, String sobrenome, String cpf, String dataNascimento, String email, String senha) {
    
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.cpf = cpf;
    this.dataNascimento = dataNascimento;
    this.email = email;
    this.senha = senha;
  }
  
  
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSobrenome() {
    return sobrenome;
  }

  public void setSobrenome(String sobrenome) {
    this.sobrenome = sobrenome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }
  
  public CadRequest() {}
}