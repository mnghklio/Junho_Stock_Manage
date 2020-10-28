package com.github.mnghklio.web.apiController;

import com.github.mnghklio.web.dto.StockDto;
import com.github.mnghklio.web.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/stock")
public class StockAPIController {

    private final StockService stockService;

    @PostMapping("/save")
    public Long stockAdd (@RequestBody StockDto stockDto) {
        return this.stockService.addStock(stockDto);
    }
}
