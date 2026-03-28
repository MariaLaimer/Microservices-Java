package br.edu.atitus.greetingservice.controllers;

import br.edu.atitus.greetingservice.configs.GreetingConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController //Indica que classe GreetingController lida com requisições HTTP.
@RequestMapping("/greeting")
public class GreetingController {

    //  Variáveis de 'application.properties':
//    @Value("${greeting-service.greeting}")
//    private String greeting;
//
//    @Value("${greeting-service.default-name}")
//    private String defaultName;

    private final GreetingConfig config; //final - Imutável.

    //Injeção de Dependência:
    public GreetingController(GreetingConfig config) {
        this.config = config;
    }

    @GetMapping({"", "/"}) //Caso seja pesquisado com '/' no final, funciona igual
    public String getGreeting(@RequestParam(required = false) String name) { //'required=false' torna opcional passar nome.
        return processGreeting(name);
    }
    @GetMapping({"/{name}"})
    public String getGreetingPath(@PathVariable String name) {
        return processGreeting(name);
    }

    @PostMapping
    public String postGreeting(@RequestBody NameRequest request){
        return processGreeting(request.getName());
    }

    private String processGreeting(String name){
        if (name == null || name.isEmpty()){
            name = config.getDefaultName();
        }
        return String.format("%s %s!!!", config.getGreeting(),name);
    }
}
