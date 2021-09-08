package com.example.wareselection.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Product> fetchAll() {
        String sql = "SELECT * FROM products";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);

        return jdbcTemplate.query(sql, rowMapper);
    }

    public Product findById(int id) {
        return jdbcTemplate.query("SELECT * FROM products WHERE id = " + id,
                new BeanPropertyRowMapper<>(Product.class))
                .get(0);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE * FROM products WHERE id = " + id);
    }

    public void update(int id) {
        //jdbcTemplate.update()
    }
}
