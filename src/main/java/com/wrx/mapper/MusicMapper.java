package com.wrx.mapper;

import com.wrx.domain.Music;
import com.wrx.domain.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MusicMapper {
    Integer getTypesNum();

    Type showType(Integer id);

    int getMusicNum(Integer userId1);

    Music music_intype(Integer i,Integer x);

    Music music_details(Integer musicId1);
}
