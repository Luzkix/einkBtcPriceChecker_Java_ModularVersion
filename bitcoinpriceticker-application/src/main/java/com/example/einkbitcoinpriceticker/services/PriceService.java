package com.example.einkbitcoinpriceticker.services;

import com.example.einkbitcoinpriceticker.models.BitcoinPriceEntity;

public interface PriceService {
  BitcoinPriceEntity getPrice(String currency);
}
