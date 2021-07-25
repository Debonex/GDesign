package com.example.debonex.mapper;

import com.example.debonex.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Debonet
 */
@Mapper
public interface IndexMapper {

    /**
     *
     * @param uid userid
     * @param password password
     * @return userinfo
     */
    public User login(String uid, String password);

    /**
     *
     * @param uid userid
     * @param password password
     * @return userid
     */
    public int register(String uid,String password);
}
