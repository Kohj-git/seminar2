package com.example.seminar2nd.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    //프론트에서 오는 json파일에 데이터 순서가 dto에 선언된 순서랑 같아야 함.
    private Long studentId;
    private String studentName;
}
