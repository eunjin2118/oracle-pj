package kr.hs.study.dbTest.service;

import kr.hs.study.dbTest.dto.bookDTO;
import kr.hs.study.dbTest.dto.bookRequestDTO;

import java.util.List;

public interface bookRequestService {
    public void insert(bookRequestDTO dto);

    public List<bookRequestDTO> select();

    public void insertbook(bookDTO dto);

    public void deleterequestbook(String request_title, String request_author);

}
