package com.example.debonex.service;

import com.example.debonex.pojo.GResponse;
import com.example.debonex.pojo.User;
import com.example.debonex.constants.Constants;
import com.example.debonex.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
 * @author Debonet
 */
@Service
public class IndexService {
    @Autowired
    IndexMapper indexMapper;

    public GResponse login(User user) {
        try {
            User resUser = indexMapper.login(user.getUid(), user.getPassword());
            if (resUser != null)
                return new GResponse(Constants.USER_LOGIN_SUCCESS);
            else return new GResponse(Constants.USER_LOGIN_FAILED);
        } catch (Exception e) {
            return new GResponse(Constants.USER_LOGIN_FAILED);
        }
    }

    public GResponse register(User user) {
        try {
            int id = indexMapper.register(user.getUid(), user.getPassword());
            return new GResponse(Constants.USER_REGISTER_SUCCESS);
        }catch (DuplicateKeyException e){
            return new GResponse(Constants.USER_REGISTER_DUPLICATE_UID);
        }
        catch (Exception e){
            return new GResponse(Constants.USER_REGISTER_FAILED);
        }
    }
}
