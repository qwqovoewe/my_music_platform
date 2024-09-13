package com.wrx.service.serviceimpl;

import com.wrx.domain.Lists;
import com.wrx.domain.Music_inList;
import com.wrx.mapper.ListMapper;
import com.wrx.service.ListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class listsServiceImpl implements ListsService {
    @Autowired
    private ListMapper listMapper;

    @Override
    public boolean createListJudge(Lists lists, Integer i) {
        if(listMapper.createListJudge(lists,i).equals(1))
            return false;
        else
            return true;
    }

    @Override
    public void createList(Lists lists, Integer i) {
        listMapper.createList(lists,i);
    }

    @Override
    public Integer getlists_Num(Integer id0) {
        return listMapper.geyList_Num(id0);
    }

    @Override
    public Lists list_in(Integer id0, int i) {
        return listMapper.list_in(id0,i);
    }

    @Override
    public boolean addJudge( Music_inList music_inList) {
        if(listMapper.find_addJudge(music_inList).equals(1))
            return false;
        else
            return true;
    }

    @Override
    public void add_music(Music_inList music_inList) {
        listMapper.add_music(music_inList);
    }

    @Override
    public Integer getmusicInListNum(Music_inList music_inList) {
        return listMapper.getmusicInListNum(music_inList);
    }

    @Override
    public Music_inList ShowMusicInList(Music_inList music_inList ) {
        return listMapper.ShowMusicInList(music_inList);
    }

    @Override
    public void delete(Lists lists) {
        listMapper.Delete(lists);
    }

    @Override
    public void deleteMusicInList(Music_inList music_inList) {
        listMapper.DeleteMusicInList(music_inList);
    }

    @Override
    public boolean DeleteListJudge(Lists lists) {
        if(listMapper.DeleteListJudge(lists).equals(1))
            return true;
        else
            return false;

    }

    @Override
    public boolean DeleteOneMusicInListJudge(Music_inList musicInList) {
        if(listMapper.DeleteOneMusicInListJudge(musicInList).equals(1))
            return true;
        else
            return false;
    }

    @Override
    public void deleteOneMusicInList(Music_inList musicInList) {
        listMapper.DeleteOneMusicInList(musicInList);
    }
}
