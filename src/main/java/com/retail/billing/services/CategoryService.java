package com.retail.billing.services;

import com.retail.billing.io.CategoryRequest;
import com.retail.billing.io.CategoryResponse;

public interface CategoryService {
    CategoryResponse add (CategoryRequest request);
}
