package com.example.debonex.controller;

import com.example.debonex.constants.Constants;
import com.example.debonex.pojo.Commodity;
import com.example.debonex.pojo.GResponse;
import com.example.debonex.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Debonet
 * @date 2021年7月28日
 */
@RequestMapping("/commodity")
@RestController
public class CommodityController {

    @Autowired
    CommodityService commodityService;

    @RequestMapping("/selectCommodityPage")
    public GResponse selectCommodityPage(@RequestParam int currentPage, @RequestParam int perPage) {
        return commodityService.selectCommodityPage(currentPage, perPage);
    }

    @RequestMapping("/insertCommodity")
    public GResponse insertCommodity(@RequestBody Commodity commodity) {
        return commodityService.insertCommodity(commodity);
    }

    @RequestMapping("/selectCommodityList")
    public GResponse selectCommodityList(@RequestBody int[] commodityIdList) {
        try {
            // Arrays.stream(arr) 可以替换成IntStream.of(arr)。
            // 1.使用Arrays.stream将int[]转换成IntStream。
            // 2.使用IntStream中的boxed()装箱。将IntStream转换成Stream<Integer>。
            // 3.使用Stream的collect()，将Stream<T>转换成List<T>，因此正是List<Integer>。
            List<Integer> list = Arrays.stream(commodityIdList).boxed().collect(Collectors.toList());
            return new GResponse(Constants.SUCCESS, commodityService.selectCommodityList(list));
        } catch (Exception e) {
            return new GResponse(Constants.FAILED);
        }
    }
}
