package com.example.currencyconversionservice.controller;

import com.example.currencyconversionservice.domain.CurrencyConversionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private ForexControllerProxy proxy;

//    @GetMapping("/cc/from/{from}/to/{to}/quantity/{qty}")
//    public ResponseEntity<CurrencyConversionBean> calulateTotalAmount(@PathVariable("from")  String from,
//                                                                      @PathVariable("to") String to,
//                                                                      @PathVariable("qty")Integer quantity){
//        Map<String, String> uriVariables = new HashMap<>();
//        uriVariables.put("from", from);
//        uriVariables.put("to", to);
//
//        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
//                "http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
//                uriVariables);
//
//        CurrencyConversionBean response = responseEntity.getBody();
//        response.setFromCurrency(from);
//        response.setToCurrency(to);
//        response.setQuantity(quantity);
//        response.setTotalCalculatedAmount(response.getRate() * quantity);
//
//        return ResponseEntity.ok(response);
//    }

    @GetMapping("/cc/from/{from}/to/{to}/quantity/{qty}")
    public ResponseEntity<CurrencyConversionBean> calulateTotalAmount(@PathVariable("from")  String from,
                                                                      @PathVariable("to") String to,
                                                                      @PathVariable("qty")Integer quantity){

        CurrencyConversionBean response = proxy.retrieveExchangeValue(from,to);
        response.setQuantity(quantity);
        response.setTotalCalculatedAmount(response.getRate() * quantity);

        return ResponseEntity.ok(response);
    }
}
