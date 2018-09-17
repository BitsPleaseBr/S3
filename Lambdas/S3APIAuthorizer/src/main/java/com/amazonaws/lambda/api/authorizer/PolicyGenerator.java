package com.amazonaws.lambda.api.authorizer;

import java.util.HashMap;
import java.util.Map;
import com.amazonaws.lambda.api.authorizer.AuthPolicy.PolicyDocument;

public class PolicyGenerator {
  static Map<String, String> resourcesAllowed = new HashMap<>();
  ArnParser arnParser;
  String principalId;

  AuthPolicy buildPolicy(boolean permitir) {
    AuthPolicy auth = new AuthPolicy();
    auth.setPrincipalId(principalId);
    PolicyDocument doc;
    if (permitir) {
      doc = PolicyDocument.getAllowAllPolicy(arnParser.getRegion(), arnParser.getAwsAccountId(),
          arnParser.getRestApiId(), arnParser.getStage());
    } else {
      doc = PolicyDocument.getDenyAllPolicy(arnParser.getRegion(), arnParser.getAwsAccountId(),
          arnParser.getRestApiId(), arnParser.getStage());
    }
    auth.setPolicyDocument(doc);
    return auth;
  }

  PolicyGenerator(ArnParser arnParser, String principalId) {
    this.arnParser = arnParser;
    this.principalId = principalId;
  }
}
