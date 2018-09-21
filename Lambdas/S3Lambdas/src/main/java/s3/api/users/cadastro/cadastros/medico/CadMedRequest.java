package s3.api.users.cadastro.cadastros.medico;

import s3.api.users.cadastro.cadastros.CadRequest;

public class CadMedRequest extends CadRequest {

  
  //Do Médico
  protected String crm, uf, pais;
  
  //Endereço Residencial
  protected String cepResidencial, cidadeResidencial, bairroResidencial, ruaResidencial, numeroResidencial, complementoResidencial;
  
  //Endereço Comercial
  protected String cepComercial, cidadeComercial, bairroComercial, ruaComercial, numeroComercial, complementoComercial;
  
  //Celular
  protected String celular;
  
  //Telefone
  protected String telefone;
  
  
  public CadMedRequest(String nome, String sobrenome, String cpf, String dataNascimento, String email, String senha,
                       String crm, String uf, String pais, String celular, String telefone,
                       String cepResidencial, String cidadeResidencial, String bairroResidencial, 
                       String ruaResidencial, String numeroResidencial, String complementoResidencial,
                       String cepComercial, String cidadeComercial, String bairroComercial,
                       String ruaComercial, String numeroComercial, String complementoComercial) {
    
    super(nome, sobrenome, cpf, dataNascimento, email, senha);
    
    this.crm  = crm;
    this.uf   = uf;
    this.pais = pais;
  
    this.celular  = celular;
    this.telefone = telefone;
    
    this.cepResidencial         = cepResidencial;
    this.cidadeResidencial      = cidadeResidencial;
    this.bairroResidencial      = bairroResidencial;
    this.ruaResidencial         = ruaResidencial;
    this.numeroResidencial      = numeroResidencial;
    this.complementoResidencial = complementoResidencial;
   
    this.cepComercial         = cepComercial;
    this.cidadeComercial      = cidadeComercial;
    this.bairroComercial      = bairroComercial;
    this.ruaComercial         = ruaComercial;
    this.numeroComercial      = numeroComercial;
    this.complementoComercial = complementoComercial;
  }
  
  
  public String getCrm() {
    return crm;
  }
  
  public void setCrm(String crm) {
    this.crm = crm;
  }

  
  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  
  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  
  public String getCepResidencial() {
    return cepResidencial;
  }

  public void setCepResidencial(String cepResidencial) {
    this.cepResidencial = cepResidencial;
  }

  
  public String getCidadeResidencial() {
    return cidadeResidencial;
  }
  
  public void setCidadeResidencial(String cidadeResidencial) {
    this.cidadeResidencial = cidadeResidencial;
  }

  
  public String getBairroResidencial() {
    return bairroResidencial;
  }

  public void setBairroResidencial(String bairroResidencial) {
    this.bairroResidencial = bairroResidencial;
  }

  
  public String getRuaResidencial() {
    return ruaResidencial;
  }

  public void setRuaResidencial(String ruaResidencial) {
    this.ruaResidencial = ruaResidencial;
  }

  
  public String getNumeroResidencial() {
    return numeroResidencial;
  }

  public void setNumeroResidencial(String numeroResidencial) {
    this.numeroResidencial = numeroResidencial;
  }

  
  public String getComplementoResidencial() {
    return complementoResidencial;
  }

  public void setComplementoResidencial(String complementoResidencial) {
    this.complementoResidencial = complementoResidencial;
  }

  
  public String getCepComercial() {
    return cepComercial;
  }

  public void setCepComercial(String cepComercial) {
    this.cepComercial = cepComercial;
  }

  
  public String getCidadeComercial() {
    return cidadeComercial;
  }

  public void setCidadeComercial(String cidadeComercial) {
    this.cidadeComercial = cidadeComercial;
  }

  
  public String getBairroComercial() {
    return bairroComercial;
  }

  public void setBairroComercial(String bairroComercial) {
    this.bairroComercial = bairroComercial;
  }

  
  public String getRuaComercial() {
    return ruaComercial;
  }

  public void setRuaComercial(String ruaComercial) {
    this.ruaComercial = ruaComercial;
  }

  
  public String getNumeroComercial() {
    return numeroComercial;
  }

  public void setNumeroComercial(String numeroComercial) {
    this.numeroComercial = numeroComercial;
  }

  
  public String getComplementoComercial() {
    return complementoComercial;
  }

  public void setComplementoComercial(String complementoComercial) {
    this.complementoComercial = complementoComercial;
  }

  
  public String getCelular() {
    return celular;
  }

  public void setCelular(String celular) {
    this.celular = celular;
  }

  
  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public CadMedRequest() {}
}