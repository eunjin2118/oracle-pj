package kr.hs.study.dbTest.service;


import kr.hs.study.dbTest.dto.bookDTO;
import kr.hs.study.dbTest.dto.categoryDTO;

import java.util.List;

public interface bookService {
    public List<bookDTO> select();

    public List<bookDTO> read();

    public List<bookDTO> search(String searchtext);

    public bookDTO bookread(Integer book_id);

    public List<categoryDTO> selectcg();

    public void updatebook(bookDTO dto);

    public void deletebook(Integer id);

}
