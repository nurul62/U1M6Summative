package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ItemDaoJdbcTemplateImpl {

      private JdbcTemplate jdbcTemplate;

    private static final String INSERT_ITEM_SQL =
            "insert into item (name, description, dailyRate) values (?, ?, ?)";
    private static final String SELECT_ITEM_SQL =
            "select * from item where item_id = ? ";

    private static final String SELECT_ALL_ITEMS_SQL =
            "select * from item ";

    private static final String UPDATE_ITEM_SQL =
            "select * from item where item_id = ? ";

    private static final String DELETE_ITEM_SQL =
            "select * from item where item_id = ? ";

    @Autowired
    public ItemDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //@Override
    @Transactional
    public Item addItem(Item item) {

        jdbcTemplate.update(
                INSERT_ITEM_SQL,
                item.getName(),
                item.getDescription(),
                item.getDailyRate());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        item.setItemId(id);

        return item;

    }



    public Item getItem(int id) {

        try {
            return jdbcTemplate.queryForObject(
                    SELECT_ITEM_SQL,
                    this::mapRowToItem,
                    id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no entry with the given id, just return null
            return null;
        }
    }


    public List<Item> getAllItems() {

        return jdbcTemplate.query(
                SELECT_ALL_ITEMS_SQL,
                this::mapRowToItem);
    }


    public void updateItem(Item item) {

        jdbcTemplate.update(
                UPDATE_ITEM_SQL,
                item.getName(),
                item.getDescription(),
                item.getDailyRate(),
                item.getItemId());
    }


    public void deleteItem(int id) {

        jdbcTemplate.update(DELETE_ITEM_SQL, id);

    }


    private Item mapRowToItem(ResultSet rs, int rowNum) throws SQLException {
        Item item = new Item();
        item.setItemId(rs.getInt("item_id"));
        item.setName(rs.getString("name"));
        item.setDescription(rs.getString("description"));
        item.setDailyRate(rs.getBigDecimal("daily_rate"));

        return item;
    }


}



