package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SMSService;
import com.devsuperior.dsmeta.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class ServiceController {
    @Autowired
    private SaleService saleService;

    @Autowired
    private SMSService smsService;
    @GetMapping
    public Page<Sale> findSales( @RequestParam(value = "minDate", defaultValue = "") String minDate,
                                 @RequestParam(value = "maxDate", defaultValue = "")String maxDate,Pageable pageable){
        return saleService.findSales(minDate, maxDate, pageable);
    }
    @GetMapping("/{id}/notification")
    public void notifySms(@PathVariable Long id){
        smsService.sendSms(id);
    }
}


