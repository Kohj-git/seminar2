package com.example.seminar2nd.user.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long studentId;
    private String studentName;

    //void updateUser(User user){
    // 중간에 정의해줌 setter 안하면
    //}
}
