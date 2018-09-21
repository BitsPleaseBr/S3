package s3.api.documentos.cadastrar;

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

    int userId = input.getIdUsuario();
    int casoId = input.getIdCasoMedico();
    int documentoId = input.getIdExame();

    String key = userId + "-" + casoId + "-" + documentoId;

    DynamoDB database = new DynamoDB(
                              AmazonDynamoDBClientBuilder.standard().withRegion(Regions.SA_EAST_1).build()
                            );

    Table tabela = database.getTable("s3_exames");
    
    Item item = new Item()
                  .withPrimaryKey("id_exame", key);
    
    for (Entry<String, Object> entrada : input.getBody().entrySet())
      item.with(entrada.getKey(), entrada.getValue());
    
    tabela.putItem(item);
    
    return response;
  }
}