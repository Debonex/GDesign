package com.example.debonex.mapper;

import com.example.debonex.pojo.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * @param currentPage current page number
     * @param perPage     commodity count per page
     * @return commodity info list
     */
    public List<Commodity> selectCommodityList(@Param("currentPage") int currentPage, @Param("perPage") int perPage);

    /**
     * @return commodity count
     */
    public int selectCommodityCount();

    /**
     *
     * @param commodity commodity info
     * @return primary key
     */
    public int insertCommodity(@Param("item")Commodity commodity);
}
