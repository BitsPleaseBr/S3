package s3.api.users.selecionar;

import java.util.HashMap;
import model.bean.info.Info;
import s3.api.Response;

public class SelecionarResponse extends Response {

  
  private HashMap<? extends Info, Object> infos;
  
  
  public void setInfos(HashMap<? extends Info, Object> infos) {
    
    this.infos = infos;
  }
  
  public HashMap<? extends Info, Object> getInfos() {
    
    return this.infos;
  }
}