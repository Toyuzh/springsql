package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserMapper userMapper;

    @PostMapping
    public String addUser(@RequestBody User user){
        int insert = userMapper.insert(user);
        return String.valueOf(insert);
    }

    @PutMapping
    public String updateUser(@RequestBody User user){
        if(user.getId()==null){
            return "id not exit";
        }

        int updated = userMapper.updateById(user);
        return String.valueOf(updated);
    }
    @DeleteMapping
    public String deleteUser(@RequestParam Integer id){
        int insert = userMapper.deleteById(id);
        return String.valueOf("delete"+id);
    }

    @GetMapping
    public User getUser(@RequestParam Integer id){
        return userMapper.selectById(id);
    }

}
