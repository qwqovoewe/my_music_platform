package com.wrx.service;

import com.wrx.domain.Music;
import com.wrx.domain.Type;
import org.springframework.stereotype.Service;

@Service
public interface MusicService {
    Type showType(Integer id);
    Integer getTypesNum();

    int getMusicNum(Integer type_id1);

    Music Music_intype(Integer i,Integer x);

    Music Music_details(Integer musicId1);
}
