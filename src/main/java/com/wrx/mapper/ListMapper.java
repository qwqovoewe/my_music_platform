package com.wrx.mapper;
import com.wrx.domain.Lists;
import com.wrx.domain.Music;
import com.wrx.domain.Music_inList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ListMapper {
    Object createListJudge(Lists lists, Integer i);

    void createList( Lists lists, Integer i);

    Integer geyList_Num(Integer id0);

    Lists list_in(Integer id0, int i);

    Integer find_addJudge( Music_inList music_inList);

    void add_music(Music_inList music_inList);

    Integer getmusicInListNum(Music_inList music_inList);

    Music_inList ShowMusicInList(Music_inList music_inList);

    void Delete(Lists lists);

    void DeleteMusicInList(Music_inList music_inList);

    Integer DeleteListJudge(Lists lists);

    Integer DeleteOneMusicInListJudge(Music_inList musicInList);

    void DeleteOneMusicInList(Music_inList musicInList);
}