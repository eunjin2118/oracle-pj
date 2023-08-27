package kr.hs.study.dbTest.dto;

import lombok.Data;

@Data
public class buserDTO {
    private Integer buser_id;
    private String name;
    private String email;
    private String password;
    private String role;
}