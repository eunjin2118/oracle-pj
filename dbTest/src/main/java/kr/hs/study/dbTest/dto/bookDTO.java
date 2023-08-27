package kr.hs.study.dbTest.dto;

import lombok.Data;

@Data
public class bookDTO {
    private Integer book_id;
    private String book_author;
    private String book_title;
    private String book_publish;
    private String book_url;
    private Integer category_id;
    private String category_name;
    private String searchtext;
}