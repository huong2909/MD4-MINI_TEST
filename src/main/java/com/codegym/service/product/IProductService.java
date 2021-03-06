package com.codegym.service.product;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IGeneralService<Product> {
    Iterable<Product> findAllByNameContaining(String name);

    Iterable<Product> findAllByOrderByPrice();

    Iterable<Product> getTop4();

    Iterable<Product> findAllByCategory(Category category);

    Iterable<Product> findAllByPriceBetween(int from, int to);
}
