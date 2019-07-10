package com.company.U1M6Summative.controller;

import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.service.ServiceLayer;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceViewController {

    @Autowired
    ServiceLayer serviceLayer;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice saveInvoice(@RequestBody @Valid InvoiceViewModel invoiceViewModel) {
        return serviceLayer.saveInvoice(invoiceViewModel);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Invoice findInvoice(@PathVariable("id") int invoiceId){
        return serviceLayer.findInvoice(invoiceId);
    }

    @DeleteMapping("/(id)")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInvoice(@PathVariable("id") int id) {
        serviceLayer.removeInvoice(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInvoice(){

    }
    @GetMapping("/customer/{customerId}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Invoice> getInvoicesByCustomerId(@PathVariable int customerId){
        return serviceLayer.findInvoiceByCustomer(customerId);
    }
}
