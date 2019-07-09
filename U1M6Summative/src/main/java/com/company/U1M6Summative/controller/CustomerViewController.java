package com.company.U1M6Summative.controller;


import com.company.U1M6Summative.service.ServiceLayer;
import com.company.U1M6Summative.viewmodel.CustomerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerViewController {
    @Autowired
    ServiceLayer serviceLayer;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerViewModel createCustomer(@RequestBody @Valid CustomerViewModel customerViewModel) {
        return serviceLayer.saveCustomer(customerViewModel);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerViewModel findAllCustomer(@RequestBody CustomerViewModel customerViewModel){
        //return serviceLayer.findAllCustomers(customerViewModel);
        return null;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  CustomerViewModel findCustomer(@PathVariable("id") int customerId){
        return serviceLayer.findCustomer(customerId);
    }

    @DeleteMapping("/(id)")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCustomer(@PathVariable("id") int customerId) {
        //serviceLayer.removeCustomer(customerId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable("id") int customerId){
        //serviceLayer.updateCustomer(customerId);
    }
}
