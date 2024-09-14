package com.wrx.controller;

import com.wrx.aop.InvokeLog;
import com.wrx.domain.Music;
import com.wrx.domain.ResponseResult;
import com.wrx.domain.Type;
import com.wrx.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/music")
public class MusicController {
@Autowired
    private MusicService musicService;
@GetMapping("/types")
@InvokeLog
    public ResponseResult showTypes(){
    Map<String, Object> map = new HashMap<>();
    for(int i=0;i<musicService.getTypesNum();i++){
        Type showTypes = musicService.showType(i+1);
        showTypes.setType_id(i+1);
        map.put(String.valueOf(i+1),showTypes.getType_name());
    }
    return new ResponseResult(200,"查询成功！",map);
}
@GetMapping("/{type_id}")
@InvokeLog
    public ResponseResult music_intype(@PathVariable String type_id){
    Map<String,Object> map =new HashMap<>();
    Integer type_id1 = Integer.valueOf(type_id);
    List<Map<String, String>> listsDetails = new ArrayList<>();

    for(int i=0;i<musicService.getMusicNum(type_id1);i++){
        Music music_intype = musicService.Music_intype(i,type_id1);
        Map<String, String> listDetail = new HashMap<>();
        listDetail.put("title",music_intype.getTitle());
        listDetail.put("singer",music_intype.getSinger());
        listDetail.put("loveOrNot",String.valueOf( music_intype.getLoveOrNot()));
        listDetail.put("wording",music_intype.getWording());
        listDetail.put("music_cover_url",music_intype.getMusic_cover_url());
        listDetail.put("music_url",music_intype.getMusic_url());
        listDetail.put("music_id",String.valueOf( music_intype.getMusic_id()));
        listsDetails.add(listDetail);
    }
    return new ResponseResult(200,"查询成功！",listsDetails);
}
@GetMapping("/choice/{music_id}")
@InvokeLog
    public ResponseResult music_details(@PathVariable String music_id){
    Map<String,Object> map =new HashMap<>();
    Integer music_id1 = Integer.valueOf(music_id);
        Music music_details = musicService.Music_details(music_id1);
        map.put("title",music_details.getTitle());
        map.put("singer",music_details.getSinger());
        map.put("loveOrNot",music_details.getLoveOrNot());
        map.put("wording",music_details.getWording());
        map.put("music_cover_url",music_details.getMusic_cover_url());
        map.put("music_url",music_details.getMusic_url());
        map.put("words",music_details.getWords());
    map.put("music_id",String.valueOf(music_details.getMusic_id()));

    return new ResponseResult(200,"查询成功！",map);
    }
    @GetMapping("/recommendations")
    @InvokeLog
    public ResponseResult music_intype(){
        Map<String,Object> map =new HashMap<>();
        List<Map<String, String>> listsDetails = new ArrayList<>();
        for(int i=0;i<musicService.getMusicNum(5);i++){
            Music music_intype = musicService.Music_intype(i,5);
            Map<String, String> listDetail = new HashMap<>();
            listDetail.put("title",music_intype.getTitle());
            listDetail.put("singer",music_intype.getSinger());
            listDetail.put("loveOrNot",String.valueOf( music_intype.getLoveOrNot()));
            listDetail.put("wording",music_intype.getWording());
            listDetail.put("music_cover_url",music_intype.getMusic_cover_url());
            listDetail.put("music_url",music_intype.getMusic_url());
            listDetail.put("music_id",String.valueOf(music_intype.getMusic_id()));
            listsDetails.add(listDetail);
        }
        return new ResponseResult(200,"查询成功！",listsDetails);
    }
}
