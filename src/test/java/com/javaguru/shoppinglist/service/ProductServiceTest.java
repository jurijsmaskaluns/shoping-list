package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mappers.BeanMapper;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductInMemoryRepository repository;
    @Mock
    private ProductValidationService validationService;
    @Mock
    private BeanMapper beanMapper;

    @InjectMocks
    private ProductService victim;

    @Test
    public void shouldSaveProduct() {
        when(repository.save(any())).thenReturn(entity());
        when(beanMapper.toDto(entity())).thenReturn(productDto(20L));

        ProductDto dto = victim.save(productDto(null));

        verify(validationService).validate(any());
        assertEquals(productDto(1L), dto);
    }

    private ProductDto productDto(Long id) {
        ProductDto dto = new ProductDto();
        dto.setId(id);
        dto.setName("PRODUCT");
        dto.setCategory("PRODUCT_CATEGORY");
        dto.setPrice(new BigDecimal("123.33"));
        dto.setDiscount(12);
        dto.setDescription("PRODUCT_DESCRIPTION");
        return dto;
    }

    private ProductEntity entity() {
        ProductEntity productEntity = new ProductEntity(20L, "PRODUCT", new BigDecimal("123.33"), 12, "PRODUCT_CATEGORY", "PRODUCT_DESCRIPTION");
        return productEntity;
    }
}