package com.company.U1M6Summative.controller;

import com.company.U1M6Summative.service.ServiceLayer;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/invoice")
public class InvoiceViewController {

    @Autowired
    ServiceLayer serviceLayer;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel createInvoice(@RequestBody @Valid InvoiceViewModel invoiceViewModel) {
        //return serviceLayer.saveInvoice(invoiceViewModel);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  InvoiceViewController getInvoice(@PathVariable("id") int invoiceId){
        //return serviceLayer.findInvoice(invoiceId)
    }

    @DeleteMapping("/(id)")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInvoice() {

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInvoice(){

    }
}
