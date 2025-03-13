package com.example.seminar2nd.user.repository;

import com.example.seminar2nd.user.dto.UserDto;
import com.example.seminar2nd.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
//잊지 말자 !! 원래는 interface로 만들음.
public class UserRepository {
    private static final Map<Long, User> handong = new HashMap<>();

    public void save(UserDto userDto){
        User user = User.builder()
                .studentId(userDto.getStudentId())
                .studentName(userDto.getStudentName())
                .build();
        handong.put(userDto.getStudentId(), user);//sturdent id 에 user의 내용을 저장한다.
    }

    public UserDto findById(Long studentId){
        User user = handong.get(studentId);
        //user를 userdto 형식으로 변환해주기위해서 builder를 사용함.
        return UserDto.builder()
                .studentId(user.getStudentId())
                .studentName(user.getStudentName())
                .build();
    }

    public List<UserDto> findAll(){
       return handong.values().stream()
               .map(user -> UserDto.builder()
                       .studentId(user.getStudentId())
                       .studentName(user.getStudentName())
                       .build()).toList();
    }

    public void update(Long studentId, UserDto userDto){
        User user = handong.get(studentId);
        user.setStudentId(userDto.getStudentId());
        user.setStudentName(userDto.getStudentName());
    }

    public void delete(Long studentId){
        handong.remove(studentId);
    }
}
