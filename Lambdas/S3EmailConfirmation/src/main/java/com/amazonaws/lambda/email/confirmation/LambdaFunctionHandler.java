package com.amazonaws.lambda.email.confirmation;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<Input, Output> {

    @Override
    public Output handleRequest(Input input, Context context) {
        Output out = new Output();
        context.getLogger().log("Input token: " + input.getToken());

        String token = input.getToken();
        
        return "Hello from Lambda!";
    }

}
