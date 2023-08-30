package kr.hs.study.dbTest.service;

import kr.hs.study.dbTest.dto.bookDTO;
import kr.hs.study.dbTest.dto.bookRequestDTO;
import kr.hs.study.dbTest.mapper.bookRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bookRequestServiceImpl implements bookRequestService{
    @Autowired
    private bookRequestMapper mapper;

    @Override
    public void insert(bookRequestDTO dto) {
        mapper.insert(dto);
    }

    @Override
    public List<bookRequestDTO> select() {
        List<bookRequestDTO> dto = mapper.select();
        return dto;
    }

    @Override
    public void insertbook(bookDTO dto) {
        mapper.insertbook(dto);
    }

    @Override
    public void deleterequestbook(String book_title, String book_author) {
        mapper.deleterequestbook(book_title, book_author);
    }

    @Override
    public void update(String book_title) {
        mapper.update(book_title);
    }
}
