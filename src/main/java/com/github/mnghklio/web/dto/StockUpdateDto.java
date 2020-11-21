package com.github.mnghklio.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class StockUpdateDto {
    private Long id;
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

    public StockUpdateDto (Long id, String client, String classification, String modelName, String price,
                           String supplyPrice, String itemNumber, String site, String user, String vendor, String memo) {
        this.id = id;
        this.classification = classification;
        this.client = client;
        this.modelName = modelName;
        this.price = price;
        this.supplyPrice = supplyPrice;
        this.itemNumber = itemNumber;
        this.site = site;
        this.user = user;
        this.vendor = vendor;
        this.memo = memo;
    }
}