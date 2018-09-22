package s3.api.documentos.cadastrar;

import java.util.HashMap;
import java.util.Map.Entry;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import s3.api.Handler;

public class WriteDocHandler extends Handler
    implements RequestHandler<WriteDocRequest, WriteDocResponse> {

  @Override
  public WriteDocResponse handleRequest(WriteDocRequest input, Context context) {

    setContext(context);

    WriteDocResponse response = new WriteDocResponse();

    HashMap<String, Object> valores = input.getValores();
    
    int userId = (Integer) valores.get("IdUsuario");
    int casoId = (Integer) valores.get("IdCasoMedico");
    int documentoId = (Integer) valores.get("IdDocumento");

    String key = userId + "-" + casoId + "-" + documentoId;

    DynamoDB database = new DynamoDB(
                              AmazonDynamoDBClientBuilder.standard().withRegion(Regions.SA_EAST_1).build()
                            );

    Table tabela = database.getTable("s3_exames");
    
    Item item = new Item()
                  .withPrimaryKey("id_exame", key);
    
    for (Entry<String, Object> entrada : input.getValores().entrySet())
      item.with(entrada.getKey(), entrada.getValue());
    
    tabela.putItem(item);
    
    return response;
  }
}