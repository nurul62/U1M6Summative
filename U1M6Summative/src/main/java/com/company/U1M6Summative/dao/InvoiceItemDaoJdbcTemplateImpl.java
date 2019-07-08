package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.InvoiceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class InvoiceItemDaoJdbcTemplateImpl implements InvoiceItemDao{

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_INVOICE_ITEM_SQL =
            "insert into invoice_item (invoice_id, item_id, quantity,unit_rate,discount) values (?, ?, ?,?,?)";
    private static final String SELECT_INVOICE_ITEM_SQL =
            "select * from invoice_item where invoice_item_id = ? ";

    private static final String SELECT_ALL_INVOICE_ITEMS_SQL =
            "select * from invoice_item ";

    private static final String UPDATE_INVOICE_ITEM_SQL =
            "select * from invoice_item where invoice_item_id = ? ";

    private static final String DELETE_INVOICE_ITEM_SQL =
            "select * from invoice_item where invoice_item_id = ? ";


    @Autowired
    public InvoiceItemDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //@Override
    @Transactional
    public InvoiceItem addInvoiceItem(InvoiceItem invoiceItem) {

        jdbcTemplate.update(
                INSERT_INVOICE_ITEM_SQL,
                invoiceItem.getInvoiceId(),
                invoiceItem.getItemId(),
                invoiceItem.getQuantity(),
                invoiceItem.getUnitRate(),
                invoiceItem.getDiscount());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        invoiceItem.setInvoiceItemId(id);

        return invoiceItem;

    }
    public InvoiceItem getInvoiceItem(int id) {

        try {
            return jdbcTemplate.queryForObject(
                    SELECT_INVOICE_ITEM_SQL,
                    this::mapRowToInvoiceItem,
                    id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no entry with the given id, just return null
            return null;
        }
    }
    public List<InvoiceItem> getAllInvoiceItems() {

        return jdbcTemplate.query(
                SELECT_ALL_INVOICE_ITEMS_SQL,
                this::mapRowToInvoiceItem);
    }


    public void updateInvoiceItem(InvoiceItem invoiceItem) {

        jdbcTemplate.update(
                UPDATE_INVOICE_ITEM_SQL,
                invoiceItem.getInvoiceId(),
                invoiceItem.getItemId(),
                invoiceItem.getQuantity(),
                invoiceItem.getUnitRate(),
                invoiceItem.getDiscount(),
                invoiceItem.getItemId());
    }


    public void deleteInvoiceItem(int id) {

        jdbcTemplate.update(DELETE_INVOICE_ITEM_SQL, id);

    }

    private InvoiceItem mapRowToInvoiceItem(ResultSet rs, int rowNum) throws SQLException {
        InvoiceItem invoiceItem = new InvoiceItem();

        invoiceItem.setInvoiceItemId(rs.getInt("invoice_item_id"));
        invoiceItem.setInvoiceId(rs.getInt("invoice_id"));
        invoiceItem.setItemId(rs.getInt("item_id"));
        invoiceItem.setQuantity(rs.getInt("quantity"));
        invoiceItem.setUnitRate(rs.getBigDecimal("unit_rate"));
        invoiceItem.setDiscount(rs.getBigDecimal("discount"));

        return invoiceItem;
    }



}
