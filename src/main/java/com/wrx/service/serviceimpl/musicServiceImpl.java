package com.wrx.service.serviceimpl;

import com.wrx.domain.Music;
import com.wrx.domain.Type;
import com.wrx.mapper.MusicMapper;
import com.wrx.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class musicServiceImpl implements MusicService {
    @Autowired
    private MusicMapper musicMapper;

    @Override
    public Type showType(Integer id) {
        return musicMapper.showType(id);
    }

    @Override
    public Integer getTypesNum() {
        return musicMapper.getTypesNum();
    }

    @Override
    public int getMusicNum(Integer type_id1) {
        return musicMapper.getMusicNum(type_id1);
    }

    @Override
    public Music Music_intype(Integer i,Integer x) {
        return musicMapper.music_intype(i,x);
    }

    @Override
    public Music Music_details(Integer musicId1) {
        return musicMapper.music_details(musicId1);
    }
}
