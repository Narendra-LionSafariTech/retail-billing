package com.retail.billing.services.impl;

import com.retail.billing.entity.CategoryEntity;
import com.retail.billing.io.CategoryRequest;
import com.retail.billing.io.CategoryResponse;
import com.retail.billing.repository.CategoryRepository;
import com.retail.billing.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    private  final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponse add (CategoryRequest request){
        CategoryEntity newCategory = convertToEntity(request);
        newCategory = categoryRepository.save(newCategory);
       return convertToResponse(newCategory);
    }

    private  CategoryResponse convertToResponse(CategoryEntity newCategory){
        return CategoryResponse.builder()
                .categoryId(newCategory.getCategoryId())
                .name(newCategory.getName())
                .description(newCategory.getDescription())
                .bgColor(newCategory.getBgColor())
                .imgUrl(newCategory.getBgColor())
                .createdAt(newCategory.getCreatedAt())
                .updatedAt(newCategory.getUpdatedAt())
                .build();
    }
    private  CategoryEntity convertToEntity(CategoryRequest request){
       return CategoryEntity.builder()
                .categoryId(UUID.randomUUID().toString())
                .name(request.getName())
                .description(request.getDescription())
                .bgColor(request.getBgColor())
                .build();
    }
}
