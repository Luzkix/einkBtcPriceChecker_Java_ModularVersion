package com.example.einkbitcoinpriceticker.models;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BitcoinPriceEntity {

  private int actualPrice;
  private int priceChange;
  private String priceChangePercentage;
  private String priceChangeSign;
  private String currency;
  private LocalDateTime lastUpdate;

  public BitcoinPriceEntity(int actualPrice, int priceChange,
                            String priceChangePercentage, String priceChangeSign,
                            String currency) {
    this.actualPrice = actualPrice;
    this.priceChange = priceChange;
    this.priceChangePercentage = priceChangePercentage;
    this.priceChangeSign = priceChangeSign;
    this.currency = currency;
    this.lastUpdate = LocalDateTime.now();
  }
}
