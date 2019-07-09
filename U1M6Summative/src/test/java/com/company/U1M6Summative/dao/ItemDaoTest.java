package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ItemDaoTest {
    @Autowired
    ItemDao itemDao;

    @Before
    public void setUp() throws Exception {
        // Clean up the test db
        List<Item> itemList = itemDao.getAllItems();
        for (Item item : itemList) {
            itemDao.deleteItem(item.getItemId());
        }
    }
    @Test
    public void addGetDeleteItem(){
        Item item = new Item();
        item.setName("Pen");
        item.setDescription("A black pen.");
        item.setDailyRate(new BigDecimal(8));
        item = itemDao.addItem(item);

        Item item1 = itemDao.getItem(item.getItemId());

        assertEquals(item1, item);

        itemDao.deleteItem(item.getItemId());

        item1 = itemDao.getItem(item.getItemId());

        assertNull(item1);
    }

}
