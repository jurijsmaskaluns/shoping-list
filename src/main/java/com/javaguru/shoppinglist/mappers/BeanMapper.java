package com.javaguru.shoppinglist.mappers;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;

public class BeanMapper {

    public ProductDto toDto(ProductEntity entity) {
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setCategory(entity.getCategory());
        dto.setDiscount(entity.getDiscount());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public ProductEntity toEntity(ProductDto dto) {
        ProductEntity entity = new ProductEntity(dto.getId(), dto.getName(), dto.getPrice(), dto.getDiscount(), dto.getCategory(), dto.getDescription());
        return entity;
    }
}
