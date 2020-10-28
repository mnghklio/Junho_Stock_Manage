package com.github.mnghklio.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class StockListDto {
    private Long id;
    private String modelName;
    private String price;
    private String site;
    private String itemNumber;
    private String user;
    private String vendor;

    @Builder
    public StockListDto (Long id, String modelName, String price,
                         String site, String itemNumber, String user,
                         String vendor
                         ) {

        this.id = id;
        this.modelName = modelName;
        this.price = price;
        this.site = site;
        this.itemNumber = itemNumber;
        this.user = user;
        this.vendor = vendor;
    }
}
