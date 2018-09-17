/*
 * Copyright 2015-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except
 * in compliance with the License. A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.amazonaws.lambda.api.authorizer;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * Handles IO for a Java Lambda function as a custom authorizer for API Gateway
 *
 * @author Jack Kohn, edited by Diogo Klein
 *
 */
public class LambdaFunctionHandler implements RequestHandler<TokenAuthorizerContext, AuthPolicy> {

  @Override
  public AuthPolicy handleRequest(TokenAuthorizerContext input, Context context) {
    String key = System.getenv("secretKey");
    String token = input.getAuthorizationToken();

    // Extrai dados do token
    TokenParser parser = new TokenParser(token);
    String id = parser.getID();
    String hash = parser.getHash();
    
    boolean autorizado = true;
    
    // Validar hash
    // Usar e-mail para coletar id e hash de senha do usuário
    DBHandler handler = new DBHandler(id);
    String principalId = handler.getId();
    String pswd = handler.getHash();
    
    // Validar token usando chave particular da lambda
    String secret = pswd + key;
    BCrypt.checkpw(secret, hash);
    if (!autorizado) {
      throw new RuntimeException("Unauthorized");
    }

    // Confere o tipo do usuário e associa a política que permite acesso à lambda
    ArnParser arnParser = new ArnParser(input.getMethodArn());

    // Retorna a política
    PolicyGenerator policyGenerator = new PolicyGenerator(arnParser, principalId);
    return policyGenerator.buildPolicy(autorizado);
  }

}
