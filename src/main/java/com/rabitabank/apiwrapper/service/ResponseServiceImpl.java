package com.rabitabank.apiwrapper.service;

import com.rabitabank.apiwrapper.dao.ResponseDao;
import com.rabitabank.apiwrapper.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseServiceImpl implements ResponseService{

    private ResponseDao responseDao;

    @Autowired
    public ResponseServiceImpl(ResponseDao responseDao) {
        this.responseDao = responseDao;
    }

    @Override
    public void save(Response response) {
        responseDao.save(response);
    }
}


