package s3.api.users.cadastro.cadastros;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.PublishRequest;

public class NotificadorSNS {
  private static final String ARNCanalCadastro = System.getenv("ARNTopicoEmail");


  public static boolean publicarCadastro(String email, String nome) {
    try {
      AmazonSNS snsClient = AmazonSNSClientBuilder.defaultClient();
      PublishRequest request = new PublishRequest();
      request.setTopicArn(ARNCanalCadastro);
      request.setMessage(email + ":" + nome);
      snsClient.publish(request);
    } catch (Exception e) {
      System.out.println("Erro ao publicar notificação de cadastro no canal: " + ARNCanalCadastro);
      e.printStackTrace();
      return false;
    }
    return true;
  }


  private NotificadorSNS() {

  }
}
