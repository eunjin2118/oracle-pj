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
    public void deleterequestbook(String request_title, String request_author) {
        mapper.deleterequestbook(request_title, request_author);
    }
}
