package kr.hs.study.dbTest.service;

import kr.hs.study.dbTest.dto.bookDTO;
import kr.hs.study.dbTest.dto.buserDTO;
import kr.hs.study.dbTest.mapper.bookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bookServiceImpl implements bookService{
    @Autowired
    private bookMapper mapper;

    @Override
    public List<bookDTO> select() {
        List<bookDTO> books = mapper.select();
        return books;
    }

    @Override
    public List<bookDTO> read() {
        List<bookDTO> books = mapper.read();
        return books;
    }

    @Override
    public List<bookDTO> search(String searchtext) {
        List<bookDTO> books = mapper.search(searchtext);
        return books;
    }
}