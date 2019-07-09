package com.company.U1M6Summative.controller;


import com.company.U1M6Summative.service.ServiceLayer;
import com.company.U1M6Summative.viewmodel.ItemViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/item")
public class ItemViewController {

    @Autowired
    ServiceLayer serviceLayer;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemViewModel createItem(@RequestBody @Valid ItemViewModel itemViewModel) {
        //return serviceLayer.saveItem(itemViewModel);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  ItemViewModel getItem(@PathVariable("id") int itemId){
        //return serviceLayer.findItem(itemId);
    }

    @DeleteMapping("/(id)")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem() {

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateItem(){

    }
}
