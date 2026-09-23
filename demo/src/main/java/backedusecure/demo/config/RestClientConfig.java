package backedusecure.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {


    // Classe de configuração que define a url base da api externa de questões
    @Bean
    public RestClient questoesRestClient(){
        return RestClient.builder()
                .baseUrl("https://opentdb.com/api.php?amount=50&encode=base64")
                .build();
    }
}
