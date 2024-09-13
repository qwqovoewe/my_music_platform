package com.wrx.service;

import com.wrx.domain.Mv;
import org.springframework.stereotype.Service;

@Service
public interface MvService {
    Integer getMvNum(Integer typeId1);

    Mv Mv_intype(int i, Integer typeId1);

    Mv Mv_details(Integer mvId1);
}
