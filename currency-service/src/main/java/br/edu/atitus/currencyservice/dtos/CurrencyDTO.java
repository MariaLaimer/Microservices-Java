package br.edu.atitus.currencyservice.dtos;

/*Todo obj. criado a partir do 'record' é imutável(Não tem Setters) e são públicos*/
public record CurrencyDTO(
        String sourceCurrency,
        String targetCurrency,
        Double conversionRate,
        String environments) {}
