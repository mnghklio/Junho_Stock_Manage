package com.github.mnghklio.web.domain.stock;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String client;

    @Column
    private String classification;

    @Column
    private String modelName;

    @Column
    private String price;

    @Column
    private String supplyPrice;

    @Column
    private String itemNumber;

    @Column
    private String site;

    @Column
    private String user;

    @Column
    private String vendor;

    @Column(columnDefinition = "TEXT")
    private String memo;

    @Builder
    public Stock (String client, String classification,
                  String modelName, String price,
                  String supplyPrice, String itemNumber,
                  String site, String user,
                  String vendor, String memo) {

        this.client = client;
        this.classification = classification;
        this.modelName = modelName;
        this.price = price;
        this.supplyPrice = supplyPrice;
        this.itemNumber = itemNumber;
        this.site = site;
        this.user = user;
        this.vendor = vendor;
        this.memo = memo;
    }

    public void update (String client, String classification,
                        String modelName, String price,
                        String supplyPrice, String itemNumber,
                        String site, String user,
                        String vendor, String memo) {

        this.client = client;
        this.classification = classification;
        this.modelName = modelName;
        this.price = price;
        this.supplyPrice = supplyPrice;
        this.itemNumber = itemNumber;
        this.site = site;
        this.user = user;
        this.vendor = vendor;
        this.memo = memo;
    }
    
    //todo: 로그인 기능 구현 후 user 참조 변경해야함. 사용자 정보를 기준으로 데이터베이스 저장
}
