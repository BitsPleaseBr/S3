package s3.api.documentos;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
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

    AmazonDynamoDB clientDB = AmazonDynamoDBClientBuilder.standard()
                                .withRegion(Regions.SA_EAST_1)
                                .build();

    return response;
  }
}