package com.wrx.controller;
import com.wrx.domain.Lists;
import com.wrx.domain.Music;
import com.wrx.domain.Music_inList;
import com.wrx.domain.ResponseResult;
import com.wrx.resolver.CurrentUserId;
import com.wrx.service.ListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/list")
public class ListsController {
    @Autowired
    private ListsService listsService;
    @PostMapping("/create")
    public ResponseResult CreateList(@RequestBody Lists lists, @CurrentUserId String id) {
        Integer i = Integer.valueOf(id);
        if (listsService.createListJudge(lists, i)) {
            listsService.createList(lists, i);
            //对重名时的判断
            return new ResponseResult(200, "创建成功!");
        } else {
            return new ResponseResult(300, "已存在同名歌单，请重试！");
        }
    }

    @GetMapping("/shows")
    public ResponseResult ShowLists(@CurrentUserId String id) {
        Integer id0 = Integer.valueOf(id);
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < listsService.getlists_Num(id0); i++) {
            Lists list_in = listsService.list_in(id0, i);
            map.put("list" + String.valueOf(i + 1) + "title", list_in.getList_name());
            map.put("list" + String.valueOf(i + 1) + "list_cover_url", list_in.getList_cover_url());
        }
        return new ResponseResult(200, "查看成功!", map);
    }

    @PostMapping("/add")
    public ResponseResult addMusic(@RequestBody Music_inList music_inList, @CurrentUserId String id) {
        Integer id0 = Integer.valueOf(id);
        music_inList.setUser_id(id0);
        if (listsService.addJudge(music_inList)) {
            listsService.add_music(music_inList);
            return new ResponseResult(200, "添加成功！");
        } else {
            return new ResponseResult(300, "歌单内已存在该歌曲！");
        }
    }

    @PostMapping("/showMusicInList")
    public ResponseResult showMusicInList(@CurrentUserId String id,@RequestBody Music_inList music_inList) {
        Integer id0 = Integer.valueOf(id);
        Map<String, Object> map = new HashMap<>();
        music_inList.setUser_id(id0);
        for (int i = 0; i < listsService.getmusicInListNum(music_inList); i++) {
            music_inList.setI(i);
            Music_inList showMusicInList = listsService.ShowMusicInList(music_inList);
            map.put("music" + String.valueOf(i + 1) + "title", showMusicInList.getTitle());
            map.put("music" + String.valueOf(i + 1) + "list_cover_url", showMusicInList.getMusic_cover_url());
            map.put("music" + String.valueOf(i + 1) + "singer", showMusicInList.getSinger());
            map.put("music" + String.valueOf(i + 1) + "music_url", showMusicInList.getMusic_url());
        }
        return new ResponseResult(200,"查询成功！",map);
    }
    @DeleteMapping("delete")
    public ResponseResult Delete(@CurrentUserId String id,@RequestBody Lists lists){
        Integer id0 = Integer.valueOf(id);
        Map<String, Object> map = new HashMap<>();
        lists.setUser_id(id0);
        Music_inList music_inList = new Music_inList();
        music_inList.setUser_id(id0);
        music_inList.setList_id(lists.getList_id());
        if(listsService.DeleteListJudge(lists)) {
            listsService.delete(lists);
            listsService.deleteMusicInList(music_inList);
            return new ResponseResult(200, "删除成功");
        }
        else{
            return  new ResponseResult(300,"歌单已经不存在！");
        }
    }
    @DeleteMapping("/deleteMusic")
    public ResponseResult DeleteMusic(@CurrentUserId String id,@RequestBody Music_inList music_inList){
        Integer id0 = Integer.valueOf(id);
        Map<String, Object> map = new HashMap<>();
        music_inList.setUser_id(id0);
        if(listsService.DeleteOneMusicInListJudge(music_inList)) {
            listsService.deleteOneMusicInList(music_inList);
            return new ResponseResult(200, "删除成功");
        }
        else{
            return  new ResponseResult(300,"歌曲已经不存在！");
        }
    }
}
