package com.example.debonex.mapper;

import com.example.debonex.pojo.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Debonet
 * @date 2021年7月27日
 */
@Mapper
public interface CommodityMapper {

    /**
     * @param idCommodity commodity id
     * @return commodity info
     */
    public Commodity selectCommodity(@Param("idCommodity") int idCommodity);
}
