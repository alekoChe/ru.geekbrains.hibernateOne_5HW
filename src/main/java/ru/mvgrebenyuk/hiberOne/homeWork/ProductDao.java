package ru.mvgrebenyuk.hiberOne.homeWork;

import java.util.List;

public interface ProductDao {

    Product findById(Long id);

    List<Product> findAll();

    Product findByName(String name);

    void save(Product product);

    void update(Long id, String tittle);

    void testCache();

}
