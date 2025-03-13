package com.example.seminar2nd.user.controller;

import com.example.seminar2nd.user.dto.UserDto;
import com.example.seminar2nd.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public String saveUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return "확인!";
    }

    @GetMapping("/{studentId}")
    public UserDto findById(@PathVariable Long studentId){
        return userService.findById(studentId);
    }

    @GetMapping("")
    //배열은 뭐다? 무조건 List
    public List<UserDto> findAll(){
        return userService.findAll();
    }

    @PatchMapping("/{studentId}")
    //pathvariable이랑 requestbody랑 동시에 할 수 있음. 둘이 형식이 다름
    public String updateById(@PathVariable Long studentId, @RequestBody UserDto userDto){
        userService.update(studentId, userDto);
        return "수정되었습니다요";
    }

    @DeleteMapping("/{studentId}")
    public String deleteById(@PathVariable Long studentId){
        userService.delete(studentId);
        return "삭제되었습니다요";
    }

}
