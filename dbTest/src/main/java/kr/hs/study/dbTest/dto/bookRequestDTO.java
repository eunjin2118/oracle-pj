package kr.hs.study.dbTest.dto;

import lombok.Data;

import java.util.Date;

@Data
public class bookRequestDTO {
    private Integer request_id;
    private Integer buser_id;
    private Date request_date;
    private String request_author;
    private String request_title;
    private Integer is_approved;
    private String book_author;
    private String book_title;
}