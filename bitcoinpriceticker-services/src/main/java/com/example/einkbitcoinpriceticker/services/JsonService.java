package com.example.einkbitcoinpriceticker.services;

import org.json.JSONObject;

public interface JsonService {
  JSONObject getJson(String currency);
}
