package com.example.einkbitcoinpriceticker.controllers;

import com.example.einkbitcoinpriceticker.services.PriceServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PriceController {

  PriceServiceImpl priceService;

  public PriceController(PriceServiceImpl priceService) {
    this.priceService = priceService;
  }

  @GetMapping({"","/"})
  String displayHomepage(Model model) {
    return "homepage";
  }

  @GetMapping("/{currency}")
  String displayPrice(@PathVariable String currency, Model model) {
    //if unknown currency, set USD as default
    if(!currency.equals("USD") && !currency.equals("EUR")) {
      currency = "USD";
    }

    model.addAttribute("bitcoinObject", priceService.getPrice(currency));
    model.addAttribute("currency", currency);

    return "pricePage";
  }

/*  //Refreshing fragment of html
  @GetMapping("/priceContainer")
  String priceContainerUpdate(Model model) {
    model.addAttribute("bitcoinObject", priceService.getPrice("USD"));

    return "homePage :: #priceContainer";
  }*/
}
