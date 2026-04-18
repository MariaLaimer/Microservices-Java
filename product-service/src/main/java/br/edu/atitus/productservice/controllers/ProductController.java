package br.edu.atitus.productservice.controllers;

import br.edu.atitus.productservice.dtos.ProductDTO;
import br.edu.atitus.productservice.entities.ProductEntity;
import br.edu.atitus.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products") /*Todos os métodos desta classe começam com esse endereço em ()*/
public class ProductController {
    private final ProductRepository repository;

    @Value("${server.port}")
    private String port;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{idproduct}")
    public ProductDTO getProduct(
            @PathVariable Long idproduct, /*Esse Annotation pega o Id da URL*/
            @RequestParam String targetCurrency /*Esse Annotation pega o paranrmetro depois de ? da URL*/
    ) throws Exception {
        ProductEntity product = repository.findById(idproduct)
                .orElseThrow(() -> new Exception("Product not found"));

        String environment = "Product-service running on Port:" + port;

        return new ProductDTO(
                product.getId(),
                product.getDescription(),
                product.getBrand(),
                product.getModel(),
                product.getPrice(),
                product.getCurrency(),
                product.getStock(),
                environment,
                null,
                targetCurrency
        );
    }
}
