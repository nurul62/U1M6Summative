package com.company.U1M6Summative.controller;


import com.company.U1M6Summative.service.ServiceLayer;
import com.company.U1M6Summative.viewmodel.CustomerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public List<CustomerViewModel> findAllCustomers(){
        return serviceLayer.findAllCustomers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  CustomerViewModel findCustomer(@PathVariable("id") int customerId){
        return serviceLayer.findCustomer(customerId);
    }

    @DeleteMapping("/(id)")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public CustomerViewModel deleteCustomer(@PathVariable("id") int id) {
        //incomplete method
        //serviceLayer.removeCustomer(id);
        return null;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public CustomerViewModel updateCustomer(@RequestBody @Valid CustomerViewModel customerViewModel, @PathVariable("id") Integer id){
        if(id != customerViewModel.getCustomerId()){
            throw new IllegalArgumentException();
        }
        //incomplete method
        //return serviceLayer.updateCustomer(customerViewModel);
        return null;
    }
}
