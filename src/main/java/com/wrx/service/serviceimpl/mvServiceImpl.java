package com.wrx.service.serviceimpl;

import com.wrx.domain.Mv;
import com.wrx.mapper.MVMapper;
import com.wrx.service.MvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class mvServiceImpl implements MvService {
    @Autowired
    private MVMapper mvMapper;

    @Override
    public Integer getMvNum(Integer typeId1) {
        return mvMapper.getMvNum(typeId1);
    }

    @Override
    public Mv Mv_intype(int i, Integer x) {
         return mvMapper.mv_intype(i,x);
    }

    @Override
    public Mv Mv_details(Integer mvId1) {
        return  mvMapper.mv_details(mvId1);
    }


}
