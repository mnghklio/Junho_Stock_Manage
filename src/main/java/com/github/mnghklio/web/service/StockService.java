package com.github.mnghklio.web.service;

import com.github.mnghklio.web.domain.stock.Stock;
import com.github.mnghklio.web.domain.stock.StockRepository;
import com.github.mnghklio.web.dto.StockDto;
import com.github.mnghklio.web.dto.StockListDto;
import com.github.mnghklio.web.dto.StockUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StockService {
    private final StockRepository stockRepository;

    @Transactional
    public Long addStock(StockDto stockDto) {
        return this.stockRepository.save(stockDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<StockListDto> getList (String company, String classification) {
        List<StockListDto> retList = new ArrayList<>();
        List<Stock> stockList;

        if(classification.equals("ALL")) {
            stockList = this.stockRepository.findByClient(company);
        }
        else {
            stockList = this.stockRepository.findByClientAndClassification(company, classification);
        }

        for (Stock stock : stockList) {
            retList.add(new StockListDto().builder()
                    .price(stock.getPrice())
                    .site(stock.getSite())
                    .modelName(stock.getModelName())
                    .id(stock.getId())
                    .itemNumber(stock.getItemNumber())
                    .user(stock.getUser())
                    .vendor(stock.getVendor())
                    .build());
        }

        return retList;
    }

    @Transactional
    public Long updateStock (StockUpdateDto stockUpdateDto) {
        Stock stock = this.stockRepository.findById(stockUpdateDto.getId()).get();

        stock.update(
                stockUpdateDto.getClient(),
                stockUpdateDto.getClassification(),
                stockUpdateDto.getModelName(),
                stockUpdateDto.getPrice(),
                stockUpdateDto.getSupplyPrice(),
                stockUpdateDto.getItemNumber(),
                stockUpdateDto.getSite(),
                stockUpdateDto.getUser(),
                stockUpdateDto.getVendor(),
                stockUpdateDto.getMemo()
        );

        return stock.getId();
    }

    @Transactional(readOnly = true)
    public Stock read (Long id) {
        return this.stockRepository.findById(id).get();
    }

    @Transactional
    public Long stockDelete (Long id) {
        this.stockRepository.delete(this.stockRepository.findById(id).get());

        return 1L;
    }
}
