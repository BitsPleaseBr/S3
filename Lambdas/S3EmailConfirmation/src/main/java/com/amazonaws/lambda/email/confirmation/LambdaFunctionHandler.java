package com.amazonaws.lambda.email.confirmation;

import org.mindrot.jbcrypt.BCrypt;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<Input, Output> {

    @Override
    public Output handleRequest(Input input, Context context) {
        final String key = System.getenv("key");
        Output out = new Output();
        context.getLogger().log("Input token: " + input.getToken());

        TokenParser parser = new TokenParser(input.getToken());
        
        // Confere se o email existe no BD
        String email = parser.getEmail();
        DBHandler handler = new DBHandler(email);
        if(!handler.existe()) {
          throw new RuntimeException("403");
        }
        // Confere se o hash do token é válido
        Boolean confirmado;
        String secret = parser.getEmail() + key;
        try {
          confirmado = BCrypt.checkpw(secret, parser.getHash());
        } catch (Exception e) {
          System.out.println("Hash mal formatado na confirmação de e-mail");
          e.printStackTrace();
          confirmado = false;
        }
        if(!confirmado) {
          throw new RuntimeException("403");
        }
        
        // Atualiza status no BD
        handler.confirmarEmail();
        
        // Monta a resposta do programa
        out.setMessage("Usuário confirmado");
        
        return out;
    }

}
