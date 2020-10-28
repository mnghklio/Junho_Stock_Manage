package com.github.mnghklio.web.dto;

import com.github.mnghklio.web.domain.stock.Stock;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class StockDto {
    private String client;
    private String classification;
    private String modelName;
    private String price;
    private String supplyPrice;
    private String itemNumber;
    private String site;
    private String user;
    private String vendor;
    private String memo;

    public Stock toEntity () {
        return new Stock().builder()
                .classification(this.classification)
                .client(this.client)
                .itemNumber(this.itemNumber)
                .memo(this.memo)
                .modelName(this.modelName)
                .price(this.price)
                .site(this.site)
                .supplyPrice(this.supplyPrice)
                .user(this.getUser())
                .vendor(this.vendor).build();
    }
}
