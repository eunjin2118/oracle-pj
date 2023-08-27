package kr.hs.study.dbTest.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class commentDTO {
    private Integer comment_id;
    private Integer buser_id;
    private Integer book_id;
    private String comment_text;
    private Date comment_date;
    private String name;
    private String comment_count;
    private String book_title;
}
