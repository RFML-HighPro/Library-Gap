package br.com.livraygap.library.interfaces;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class FilterBook {
    private String filter;
    private Double optionalPriceMin;
    private Double optionalPriceMax;
    private Boolean optionalMoreSold;
    private Boolean optionalRecommended;
}