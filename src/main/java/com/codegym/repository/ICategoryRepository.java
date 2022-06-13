package com.codegym.repository;

import com.codegym.model.Category;
import com.codegym.service.IGeneralService;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
