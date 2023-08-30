package kr.hs.study.dbTest.dto;

import lombok.Data;

@Data
public class categoryDTO {
    private Integer category_id;
    private String category_name;
    private Integer book_count;
}