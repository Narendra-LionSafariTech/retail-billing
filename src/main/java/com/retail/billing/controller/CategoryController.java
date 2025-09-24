package com.retail.billing.controller;

import com.retail.billing.io.CategoryRequest;
import com.retail.billing.io.CategoryResponse;
import com.retail.billing.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse addCategory(@RequestBody CategoryRequest request){
        return  categoryService.add(request);
    }
}
