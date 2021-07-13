package com.example.debonex.mapper;

import com.example.debonex.pojo.Commodity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommodityMapper {

    public Commodity selectById(Integer id);

}
