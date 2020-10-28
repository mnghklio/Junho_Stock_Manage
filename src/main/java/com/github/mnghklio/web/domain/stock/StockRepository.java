package com.github.mnghklio.web.domain.stock;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findByClient (String company);
    List<Stock> findByClientAndClassification (String company, String classification);
}
