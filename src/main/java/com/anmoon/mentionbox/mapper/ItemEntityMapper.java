package com.anmoon.mentionbox.mapper;

import com.anmoon.mentionbox.dto.response.ItemResponse;
import com.anmoon.mentionbox.entity.ItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ItemEntityMapper {

    ItemEntityMapper INSTANCE = Mappers.getMapper(ItemEntityMapper.class);
    ItemEntity mapToItemEntity(ItemResponse itemResponse);

    ItemResponse mapToItemResponse(ItemEntity itemEntity);



}
