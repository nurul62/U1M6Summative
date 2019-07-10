
//package com.company.U1M6Summative.controller;
//
//
//import com.company.U1M6Summative.service.ServiceLayer;
//import com.company.U1M6Summative.viewmodel.ItemViewModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("/item")
//public class ItemViewController {
//
////    @Autowired
////    ServiceLayer serviceLayer;
////    @PostMapping
////    @ResponseStatus(HttpStatus.CREATED)
////    public ItemViewModel createItem(@RequestBody @Valid ItemViewModel itemViewModel) {
////        //return serviceLayer.saveItem(itemViewModel);
////    }
////
////    @GetMapping("/{id}")
////    @ResponseStatus(HttpStatus.OK)
////    public  ItemViewModel getItem(@PathVariable("id") int itemId){
////        //return serviceLayer.findItem(itemId);
////    }
////
////    @DeleteMapping("/(id)")
////    @ResponseStatus(HttpStatus.NO_CONTENT)
////    public void deleteItem() {
////
////    }
////
////    @PutMapping("/{id}")
////    @ResponseStatus(HttpStatus.NO_CONTENT)
////    public void updateItem(){
////
////    }
////}
//=======
//package com.company.U1M6Summative.controller;
//
//
//import com.company.U1M6Summative.model.Item;
//import com.company.U1M6Summative.service.ServiceLayer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("/item")
//public class ItemViewController {
//
//<<<<<<< HEAD
////    @Autowired
////    ServiceLayer serviceLayer;
////    @PostMapping
////    @ResponseStatus(HttpStatus.CREATED)
////    public ItemViewModel createItem(@RequestBody @Valid ItemViewModel itemViewModel) {
////        //return serviceLayer.saveItem(itemViewModel);
////        return itemViewModel;
////    }
////
////    @GetMapping("/{id}")
////    @ResponseStatus(HttpStatus.OK)
////    public  ItemViewModel getItem(@PathVariable("id") int itemId){
////        //return serviceLayer.findItem(itemId);
////        return null;
////    }
////
////    @DeleteMapping("/(id)")
////    @ResponseStatus(HttpStatus.NO_CONTENT)
////    public void deleteItem() {
////
////    }
////
////    @PutMapping("/{id}")
////    @ResponseStatus(HttpStatus.NO_CONTENT)
////    public void updateItem(){
////
////    }
//=======
//    @Autowired
//    ServiceLayer serviceLayer;
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Item createItem(@RequestBody @Valid ItemViewModel itemViewModel) {
//        return serviceLayer.saveItem(itemViewModel);
//    }
//
//    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Item getItem(@PathVariable("id") int id){
//        return serviceLayer.findItem(id);
//    }
//
//    @DeleteMapping("/(id)")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteItem(@PathVariable("id") int id) {
//        serviceLayer.removeItem(id);
//    }
//
//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public ItemViewModel updateItem(@RequestBody @Valid ItemViewModel itemViewModel, @PathVariable("id") int id){
////        if(id != itemViewModel.getId){
////            throw new IllegalArgumentException();
////        } else {
////            return serviceLayer.updateItem(itemViewModel);
////        }
//        return null;
//    }
//>>>>>>> origin/master
//}
//>>>>>>> origin/master
