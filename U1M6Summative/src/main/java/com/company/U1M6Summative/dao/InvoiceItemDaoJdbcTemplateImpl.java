package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.InvoiceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InvoiceItemDaoJdbcTemplateImpl implements InvoiceItemDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public InvoiceItemDaoJdbcTemplateImpl(JdbcTemplate newJdbcTemplate){
        this.jdbcTemplate = newJdbcTemplate;
    }

    //    Prepared Statement strings
    private static final String INSERT_INVOICEITEM_SQL =
            "insert into invoice_item (invoice_id, item_id, quantity, unit_rate, discount) values (?, ?, ?, ?, ?)";
    private static final String SELECT_INVOICEITEM_SQL =
            "select * from invoice_item where invoice_item_id = ?";

    private static final String SELECT_ALL_INVOICEITEM_SQL =
            "select * from invoice_item";

    private static final String DELETE_INVOICEITEM_SQL =
            "delete from invoice_item where invoice_item_id = ?";

    private static final String UPDATE_INVOICEITEM_SQL =
            "update invoice_item set invoice_id = ?, item_id = ?, quantity = ?, unit_rate = ?, discount = ? where invoice_item_id = ?";

    private static final String SELECT_INVOICEITEMBYINVOICE_SQL =
            "select * from invoice_item where invoice_id = ?";

    @Override
    public InvoiceItem addInvoiceItem(InvoiceItem invoiceItem) {
        jdbcTemplate.update(INSERT_INVOICEITEM_SQL,
                invoiceItem.getInvoiceId(),
                invoiceItem.getItemId(),
                invoiceItem.getQuantity(),
                invoiceItem.getUnitRate(),
                invoiceItem.getDiscount());

        int id = jdbcTemplate.queryForObject("select last_insert_id()",Integer.class);
        invoiceItem.setInvoiceItemId(id);
        return invoiceItem;
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

    @Override
    public InvoiceItem getInvoiceItem(int invoiceItemId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_INVOICEITEM_SQL,this::mapRowToInvoiceItem, invoiceItemId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<InvoiceItem> getAllInvoiceItem() {
        return jdbcTemplate.query(SELECT_ALL_INVOICEITEM_SQL, this::mapRowToInvoiceItem);
    }

    @Override
    public void updateInvoiceItem(InvoiceItem invoiceItem) {
        jdbcTemplate.update(UPDATE_INVOICEITEM_SQL,
                invoiceItem.getInvoiceId(),
                invoiceItem.getItemId(),
                invoiceItem.getQuantity(),
                invoiceItem.getUnitRate(),
                invoiceItem.getDiscount(),
                invoiceItem.getInvoiceItemId());
    }

    @Override
    public void deleteInvoiceItem(int invoiceItemId) {
        jdbcTemplate.update(DELETE_INVOICEITEM_SQL,invoiceItemId);
    }

    @Override
    public List<InvoiceItem> getInvoiceItemsByInvoice(int invoiceId) {
        return jdbcTemplate.query(SELECT_INVOICEITEMBYINVOICE_SQL, this::mapRowToInvoiceItem, invoiceId);
    }



}
