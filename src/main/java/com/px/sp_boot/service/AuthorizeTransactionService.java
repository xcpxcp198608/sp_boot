package com.px.sp_boot.service;

import com.px.sp_boot.oxm.dao.AuthorizeTransactionDao;
import com.px.sp_boot.oxm.pojo.AuthorizePayInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AuthorizeTransactionService {

    @Resource
    private AuthorizeTransactionDao authorizeTransactionDao;

    public List<AuthorizePayInfo> list(){
        return authorizeTransactionDao.selectAll();
    }

}
