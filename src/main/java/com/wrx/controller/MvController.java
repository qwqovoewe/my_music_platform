package com.wrx.controller;
import com.wrx.domain.Mv;
import com.wrx.domain.Music;
import com.wrx.domain.ResponseResult;
import com.wrx.service.MvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mv")
public class MvController {
@Autowired
   private MvService mvService;
   @GetMapping("/{type_id}")
   public ResponseResult mv_intype(@PathVariable String type_id){
      Map<String,Object> map =new HashMap<>();
      Integer type_id1 = Integer.valueOf(type_id);
      for(int i=0;i<mvService.getMvNum(type_id1);i++){
         Mv mv_intype = mvService.Mv_intype(i,type_id1);
         map.put("mv"+String.valueOf(i+1)+"description",mv_intype.getDescription());
         map.put("mv"+String.valueOf(i+1)+"movie_url",mv_intype.getMovie_url());
         map.put("mv"+String.valueOf(i+1)+"title",mv_intype.getTitle());
         map.put("mv"+String.valueOf(i+1)+"singer",mv_intype.getPicture_url());
         map.put("mv"+String.valueOf(i+1)+"music_url",mv_intype.getMusic_url());

      }
      return new ResponseResult(200,"查询成功！",map);
   }
   @GetMapping("/choice/{mv_id}" )
   public ResponseResult mv_details(@PathVariable String mv_id){
      Map<String,Object> map =new HashMap<>();
      Integer mv_id1 = Integer.valueOf(mv_id);
      Mv mv_details = mvService.Mv_details(mv_id1);
      map.put("title",mv_details.getTitle());
      map.put("singer",mv_details.getSinger());
      map.put("picture_url",mv_details.getPicture_url());
      map.put("description",mv_details.getDescription());
      map.put("movie_url",mv_details.getMovie_url());
      map.put("music_url",mv_details.getMusic_url());
      return new ResponseResult(200,"查询成功！",map);
   }
   @GetMapping("/recommendations")
      public ResponseResult music_intype(){
      Map<String,Object> map =new HashMap<>();
      for(int i=0;i<mvService.getMvNum(5);i++){
         Mv mv_intype = mvService.Mv_intype(i,5);
         map.put("mv"+String.valueOf(i+1)+"description",mv_intype.getDescription());
         map.put("mv"+String.valueOf(i+1)+"movie_url",mv_intype.getMovie_url());
         map.put("mv"+String.valueOf(i+1)+"title",mv_intype.getTitle());
         map.put("mv"+String.valueOf(i+1)+"singer",mv_intype.getPicture_url());
         map.put("mv"+String.valueOf(i+1)+"music_url",mv_intype.getMusic_url());
      }
      return new ResponseResult(200,"查询成功！",map);
   }
}