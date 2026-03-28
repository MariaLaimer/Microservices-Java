package br.edu.atitus.greetingservice.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component //Quando iniciar a aplicação, Spring vai criar uma dessa classe.
@ConfigurationProperties(prefix = "greeting-service")
public class GreetingConfig {
    private String greeting;
    private String defaultName;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }
}
