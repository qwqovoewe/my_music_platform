package com.wrx.mapper;

import com.wrx.domain.Mv;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MVMapper {
    int getMvNum(Integer typeId1);

    Mv mv_intype(Integer i, Integer x);

    Mv mv_details(Integer mvId1);
}
