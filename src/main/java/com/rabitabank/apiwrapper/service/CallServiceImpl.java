package com.rabitabank.apiwrapper.service;

import com.rabitabank.apiwrapper.dao.CallDao;
import com.rabitabank.apiwrapper.entity.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CallServiceImpl implements CallService{

    private CallDao callDao;

    @Autowired
    public CallServiceImpl(CallDao callDao) {
        this.callDao = callDao;
    }

    @Override
    @Transactional
    public void save(Call call) {
        callDao.save(call);
    }
}
