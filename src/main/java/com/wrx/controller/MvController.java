package com.wrx.controller;
import com.wrx.aop.InvokeLog;
import com.wrx.domain.Mv;
import com.wrx.domain.Music;
import com.wrx.domain.ResponseResult;
import com.wrx.service.MvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mv")
public class MvController {
@Autowired
   private MvService mvService;
   @GetMapping("/{type_id}")
   @InvokeLog
   public ResponseResult mv_intype(@PathVariable String type_id){
      Map<String,Object> map =new HashMap<>();
      Integer type_id1 = Integer.valueOf(type_id);
      List<Map<String, String>> listsDetails = new ArrayList<>();

      for(int i=0;i<mvService.getMvNum(type_id1);i++){
         Mv mv_intype = mvService.Mv_intype(i,type_id1);
         Map<String, String> listDetail = new HashMap<>();
         listDetail.put("description",mv_intype.getDescription());
         listDetail.put("movie_url",mv_intype.getMovie_url());
         listDetail.put("title",mv_intype.getTitle());
         listDetail.put("singer",mv_intype.getSinger());
         listDetail.put("mv_id",String.valueOf(mv_intype.getMv_id()));
         listDetail.put("pictute_url",mv_intype.getPicture_url());
         listsDetails.add(listDetail);
      }
      return new ResponseResult(200,"查询成功！",listsDetails    );
   }
   @GetMapping("/choice/{mv_id}" )
   @InvokeLog
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
      map.put("mv_id",String.valueOf(mv_details.getMv_id()));
      return new ResponseResult(200,"查询成功！",map);
   }
//   @GetMapping("/recommendations")
//   @InvokeLog
//      public ResponseResult music_intype(){
//      Map<String,Object> map =new HashMap<>();
//      List<Map<String, String>> listsDetails = new ArrayList<>();
//      for(int i=0;i<mvService.getMvNum(5);i++){
//         Mv mv_intype = mvService.Mv_intype(i,5);
//         Map<String, String> listDetail = new HashMap<>();
//         listDetail.put("description",mv_intype.getDescription());
//         listDetail.put("movie_url",mv_intype.getMovie_url());
//         listDetail.put("title",mv_intype.getTitle());
//         listDetail.put("picture_url",mv_intype.getPicture_url());
//         listDetail.put("music_url",mv_intype.getMusic_url());
//         listDetail.put("mv_id",String.valueOf(mv_intype.getMv_id()));
//         listsDetails.add(listDetail);
//      }
//      return new ResponseResult(200,"查询成功！",listsDetails);
//   }
}