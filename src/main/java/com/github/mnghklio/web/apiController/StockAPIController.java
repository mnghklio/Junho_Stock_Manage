package com.github.mnghklio.web.apiController;

import com.github.mnghklio.web.dto.StockDto;
import com.github.mnghklio.web.dto.StockUpdateDto;
import com.github.mnghklio.web.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/stock")
public class StockAPIController {

    private final StockService stockService;

    @PostMapping("/save")
    public Long stockAdd (@RequestBody StockDto stockDto) {
        return this.stockService.addStock(stockDto);
    }

    @DeleteMapping("/delete/{id}")
    public Long stockDelete (@PathVariable("id") Long id) {
        return this.stockService.stockDelete(id);
    }

    @PutMapping("/update")
    public Long stockUpdate (@RequestBody StockUpdateDto stockUpdateDto) {
        return this.stockService.updateStock(stockUpdateDto);
    }
}
