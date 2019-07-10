package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Item;
import com.company.U1M6Summative.viewmodel.ItemViewModel;

import java.util.List;

public interface ItemDao {

    Item addItem(Item item);

    Item getItem(int itemId);

    List<Item> getAllItems();

    Item updateItem(Item item);

    Item deleteItem(int itemId);

}
