package br.edu.atitus.productservice.dtos;

/*DTO -> Data Tranfer Object ou Objeto de Transferência de Dados*/
public record ProductDTO(
        Long id,
        String description,
        String brand,
        String model,
        Double price,
        String currency,
        Integer stock,
        String environment,
        Double convertedPrice,
        String requestedCurrency
) {}
