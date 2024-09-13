package com.wrx.service;

import com.wrx.domain.Lists;
import com.wrx.domain.Music;
import com.wrx.domain.Music_inList;
import org.springframework.stereotype.Service;

@Service
public interface ListsService {
    boolean createListJudge(Lists lists, Integer i);

    void createList(Lists lists, Integer i);

    Integer getlists_Num(Integer id0);

    Lists list_in(Integer id0, int i);

    boolean addJudge( Music_inList music_inList);

    void add_music( Music_inList music_inList);

    Integer getmusicInListNum(Music_inList music_inList);

    Music_inList ShowMusicInList(Music_inList music_inList);

    void delete(Lists lists);

    void deleteMusicInList(Music_inList music_inList);

    boolean DeleteListJudge(Lists lists);

    boolean DeleteOneMusicInListJudge(Music_inList musicInList);

    void deleteOneMusicInList(Music_inList musicInList);
}
