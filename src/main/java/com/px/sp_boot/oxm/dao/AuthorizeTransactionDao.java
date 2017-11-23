package com.px.sp_boot.oxm.dao;

import com.px.sp_boot.oxm.pojo.AuthorizePayInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface AuthorizeTransactionDao {

    void insertOne(AuthorizePayInfo authorizePayInfo);
    int countByKeyAndDate(AuthorizePayInfo authorizePayInfo);
    List<AuthorizePayInfo> selectAll();
}
