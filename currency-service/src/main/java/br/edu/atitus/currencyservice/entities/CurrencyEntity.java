package br.edu.atitus.currencyservice.entities;

import jakarta.persistence.*;

@Entity /*Diz ao Spring que isso vira uma tabela no banco*/
@Table(name = "tb_currency")
public class CurrencyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sourceCurrency")
    private String sourceCurrency;
    @Column(name = "targetCurrency")
    private String targetCurrency;
    @Column(name = "conversionRate")
    private Double conversionRate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public Double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Double conversionRate) {
        this.conversionRate = conversionRate;
    }
}
