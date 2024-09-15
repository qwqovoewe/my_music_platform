package com.wrx.controller;

import cn.hutool.crypto.digest.BCrypt;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wrx.aop.InvokeLog;
import com.wrx.domain.Page;
import com.wrx.domain.ResponseResult;
import com.wrx.domain.User;
import com.wrx.resolver.CurrentUserId;
import com.wrx.service.UserService;
import com.wrx.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/user")
public class  UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    @InvokeLog
    public ResponseResult insertUser(@RequestBody User user){
        if(userService.registerJudge(user))
        {
//            String hashpw= BCrypt.hashpw(user.getPassword());
//            user.setPassword(hashpw);
            userService.insertUser(user);

            user.setUser_id(userService.getUserID(user));
            userService.insertList(user);
            return new ResponseResult(200, "添加成功!");
        }
        else{
            return new ResponseResult(300,"用户名已经被注册，请重试！");
        }
    }

    @PostMapping("/login")
    @InvokeLog
    public ResponseResult login(@RequestBody User user) {
        User loginUser = userService.login(user);
//        User tem = userService.showfromname(user);

        //校验用户名密码
        Map<String, Object> map = new HashMap<>();
//        if (BCrypt.checkpw( user.getPassword(),tem.getPassword()) && loginUser != null) {
        if (loginUser!=null) {
//成功，生产token
            String token = JwtUtil.createJWT(UUID.randomUUID().toString(),String.valueOf(loginUser.getUser_id()), null);
            map.put("token", token);
            return new ResponseResult(200, "登陆成功！", map);
        }
        else {
            return new ResponseResult(300, "用户名或密码错误，请重新登陆！");
        }

    }

    @PostMapping("/editor")
    @InvokeLog
    public ResponseResult editor(@RequestBody User user, @CurrentUserId String id){
    Map<String,Object> map =new HashMap<>();
        Integer id1 = Integer.valueOf(id);
        user.setUser_id(id1);
        map.put("nickname", user.getNickname());
        map.put("sex",user.getSex());
        map.put("hobby", user.getHobby());
    if(userService.update(user)!=0){
    return  new ResponseResult(200,"您已编辑成功!",map);
    }
    else{
        return  new ResponseResult(300,"编辑失败，请重试！");
        }
    }
    @GetMapping("/show")
    @InvokeLog
    public ResponseResult show(User user, @CurrentUserId String id){
        Map<String,Object> map =new HashMap<>();
        Integer id1 = Integer.valueOf(id);
        user.setUser_id(id1);
        User user1 =userService.show(user);
        map.put("nickname", user1.getNickname());
        map.put("password", user1.getPassword());
        map.put("sex",user1.getSex());
        map.put("hobby", user1.getHobby());
        return new ResponseResult(200,"",map);
    }
    @PostMapping("/selecttall")
    public ResponseResult selecttall(){
        List<User> users=userService.selectAll();
        if(users.size()!=0){
            return new ResponseResult<>(200,"查询成功！",users);
        }
        else {
            return  new ResponseResult(300,"查询失败，请重试！");
        }
    }
    @PostMapping("/selectPage")
    public ResponseResult selcetall(@RequestBody Page page) {

        //这一句一定要放在查出所有数据的上边，第一个数表示pageNum，第二个数表示pageSize
        PageHelper.startPage(page.getPagenum(),page.getCounts());
        //这里表示要获取所有的信息
        List<User> users=userService.selectAll();
        //转换成分页的形式，这里做改动后返回值于原来相比格式发生变化，要及时调整前端接收数据的格式。
        PageInfo pageInfo = new PageInfo(users);
        if(pageInfo.getSize()!=0){
            return new ResponseResult(200,"查询成功",pageInfo);
        }
        else{
            return new ResponseResult(300,"查询失败");
        }
    }
}




