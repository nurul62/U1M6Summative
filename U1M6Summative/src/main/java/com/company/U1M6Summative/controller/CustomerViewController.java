package com.company.U1M6Summative.controller;


import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.service.ServiceLayer;
import com.company.U1M6Summative.viewmodel.CustomerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/store")
public class CustomerViewController {

    @Autowired
    private ServiceLayer service;

    @PostMapping("/customers")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody @Valid Customer customer){
        return service.addCustomer(customer);
    }
//
//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<CustomerViewModel> findAllCustomers(){
//        return serviceLayer.findAllCustomers();
//    }
//
//    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public  CustomerViewModel findCustomer(@PathVariable("id") int customerId){
//        return serviceLayer.findCustomer(customerId);
//    }
//
//    @DeleteMapping("/(id)")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void removeCustomer(@PathVariable("id") int customerId) {
//        //serviceLayer.removeCustomer(customerId);
//    }
//
//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateCustomer(@PathVariable("id") int customerId){
//        //serviceLayer.updateCustomer(customerId);
//    }
}
