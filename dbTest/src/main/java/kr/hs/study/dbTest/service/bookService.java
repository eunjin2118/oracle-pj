package kr.hs.study.dbTest.service;


import kr.hs.study.dbTest.dto.bookDTO;

import java.util.List;

public interface bookService {
    public List<bookDTO> select();

    public List<bookDTO> read();

    public List<bookDTO> search(String searchtext);
}
