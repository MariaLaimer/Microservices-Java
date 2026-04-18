package br.edu.atitus.currencyservice.controllers;

import br.edu.atitus.currencyservice.dtos.CurrencyDTO;
import br.edu.atitus.currencyservice.entities.CurrencyEntity;
import br.edu.atitus.currencyservice.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController /*Bean gerenciado pelo Spring*/
@RequestMapping("currency") //Essa controladora será mapeada
public class CurrencyController {
    private final CurrencyRepository repository;

    @Value("${server.port}")
    private String port;

    /*Método Contrutor com Injeção de Dependência:*/
    public CurrencyController(CurrencyRepository repository, Environment environment) {
        this.repository = repository;
    }

    @GetMapping("/convert") //Método HTTP que o método estará utilizando
    public ResponseEntity<CurrencyDTO> getConvert(
            /*Retorna DTO e recebe como parâmetro um source e um target*/
            @RequestParam String source,
            @RequestParam String target) throws Exception {

        /*Strings são imutáveis, então estão referenciando:*/
        source = source.toUpperCase();
        target = target.toUpperCase();
        CurrencyEntity currency = repository.findBySourceCurrencyAndTargetCurrency(source, target).orElseThrow(
                () -> new Exception("Currency not found")
        );
        String environment = "Currency Service running on port" + port;

        CurrencyDTO dto = new CurrencyDTO(
                currency.getSourceCurrency(),
                currency.getTargetCurrency(),
                currency.getConversionRate(),
                environment
        );
        return ResponseEntity.ok(dto);
    }
}