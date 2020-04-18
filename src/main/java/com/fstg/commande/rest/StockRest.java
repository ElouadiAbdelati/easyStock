/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.rest;

import com.fstg.commande.bean.Produit;
import com.fstg.commande.bean.Stock;
import com.fstg.commande.service.StockService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pc
 */
@RestController
@RequestMapping("/easyStock/stock")
public class StockRest {
    @Autowired
   private StockService stockService;
     @PostMapping("/")
    public void save(@RequestBody Stock stock) {
        stockService.save(stock);
    }
      @PostMapping("/stockFull")
    public Stock stockFull(@RequestBody Produit produit) {
        return stockService.stockFull(produit);
    }

    public StockService getStockService() {
        return stockService;
    }

    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }
    
    
}
